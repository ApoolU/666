<template>
  <base-wrapper
>
<div class="flex-between-start" style="background-color: #5D5FEF; height: 140px;">
    <div class="flex-c-center-start h-full">
      <div class="m-x-20">
          <span style="font-weight: bold; font-size: 20px; color: #FFFFFF;">BUG优先级管理</span>
      </div>
      <div class="m-x-20 m-t-4">
        <span style="font-size: 14px; color: #FFFFFF;">编号、优先级描述。</span>
      </div>
    </div>
    <div class="flex-start-end h-full m-r-10">
        <img src="@/assets/logo/document.png" height="130px" />
    </div>
</div>
<el-breadcrumb
separator="/"
class="m-20"
>
<el-breadcrumb-item
:to="{ path: '/' }"
>
首页
</el-breadcrumb-item>
<el-breadcrumb-item
:to="{ path: '/bug_priority_status' }"
>
BUG优先级管理
</el-breadcrumb-item>
<el-breadcrumb-item
>
BUG优先级详情
</el-breadcrumb-item>
</el-breadcrumb>
<base-wrapper
class="p-10"
>
<el-tabs
style="height: 200px"
class="demo-tabs"
>
<el-tab-pane
label="BUG优先级详情"
>
<el-form
:model='form'
ref='dataFormRef'
label-position='top'
:rules='{"priorityStatusDescription":[{"trigger":"blur","message":"优先级描述不能为空","required":true}]}'
label-width='150px'
>
    <el-form-item  label="优先级描述" prop="priorityStatusDescription">
        <el-input clearable placeholder="请输入优先级描述" v-model="form.priorityStatusDescription" />
    </el-form-item>

</el-form>
<base-layout
style="text-align: center;"
w_full="true"
>
<el-button
@click="submitForm"
round
color="#5D5FEF"
style="width: 200px;"
type="primary"
>保 存</el-button>
</base-layout>
</el-tab-pane>
<el-tab-pane
label="查看BUG"
>
<bug_info
 :params="{bugPriority:routerQuery.priorityStatusId}"
 />
</el-tab-pane>
</el-tabs>
</base-wrapper>
</base-wrapper>
</template>

<script setup>

const { proxy } = getCurrentInstance();
let form = ref({});
let formAll = ref({});
let rules = ref({});
let routerQuery = proxy.$route.query;
let detail = ref('normally')

function submitForm() {
  proxy.$refs.dataFormRef.validate(async (valid) => {
    if (valid) {
      let res = await proxy.$api.bug_priority_status['update'](form.value);
      proxy.$modal.msgSuccess(res.message);
      if(res.code == 0){
        refresh();
      }
    }
  });
}

async function getDetail(id) {
    let res = await proxy.$api.bug_priority_status['get'](id);
    if(res.code == 0){
        form.value = Object.assign({}, res.data);
    }
    else{
        proxy.$modal.msgError(res.message);
    }
}

async function getDetailAll(id){
    let res = await proxy.$api.bug_priority_status['get'](id);
    if(res.code == 0){
        formAll.value = Object.assign({}, res.data);
    }
    else{
        proxy.$modal.msgError(res.message);
    }
}

function refresh(){
    if(routerQuery.priorityStatusId){
        getDetail(routerQuery.priorityStatusId);
    }
    if(detail.value == 'all'){
        if(routerQuery.priorityStatusId){
            getDetailAll(routerQuery.priorityStatusId);
        }
    }
}

refresh();

</script>

<style lang="scss" scoped></style>