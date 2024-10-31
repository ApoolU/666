<template>
  <base-wrapper
>
<div class="flex-between-start" style="background-color: #5D5FEF; height: 140px;">
    <div class="flex-c-center-start h-full">
      <div class="m-x-20">
          <span style="font-weight: bold; font-size: 20px; color: #FFFFFF;">用户管理</span>
      </div>
      <div class="m-x-20 m-t-4">
        <span style="font-size: 14px; color: #FFFFFF;">编号、姓名、手机号、技术方向。</span>
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
:to="{ path: '/user_info' }"
>
用户管理
</el-breadcrumb-item>
<el-breadcrumb-item
>
用户详情
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
label="用户详情"
>
<el-form
:model='form'
ref='dataFormRef'
label-position='top'
:rules='{"userName":[{"trigger":"blur","message":"姓名不能为空","required":true}],"technicalDirection":[{"trigger":"blur","message":"技术方向不能为空","required":true}]}'
label-width='150px'
>
    <el-form-item  label="姓名" prop="userName">
        <el-input clearable placeholder="请输入姓名" v-model="form.userName" />
    </el-form-item>

    <el-form-item  label="手机号" prop="phoneNumber">
        <el-input clearable placeholder="请输入手机号" v-model="form.phoneNumber" />
    </el-form-item>

    <el-form-item   label="技术方向" prop="technicalDirection">
        <base-select clearable v-model="form.technicalDirection" api="user_info_all.get_technical_direction_status_list"></base-select>
    </el-form-item>

</el-form>
<base-cell
header="所属技术方向枚举"
label-width="180px"
class="m-b-10"
>
<base-cell-item
label="技术方向描述"
>
{{ formAll.technicalStatusDescription }}
</base-cell-item>
</base-cell>
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
 :params="{bugDiscoverer:routerQuery.userInfoId}"
 />
</el-tab-pane>
<el-tab-pane
label="查看BUG"
>
<bug_info
 :params="{bugSubmitter:routerQuery.userInfoId}"
 />
</el-tab-pane>
<el-tab-pane
label="查看BUG"
>
<bug_info
 :params="{bugHandler:routerQuery.userInfoId}"
 />
</el-tab-pane>
<el-tab-pane
label="查看项目信息"
>
<project_info
 :params="{projectLeader:routerQuery.userInfoId}"
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
let detail = ref('all')

function submitForm() {
  proxy.$refs.dataFormRef.validate(async (valid) => {
    if (valid) {
      let res = await proxy.$api.user_info['update'](form.value);
      proxy.$modal.msgSuccess(res.message);
      if(res.code == 0){
        refresh();
      }
    }
  });
}

async function getDetail(id) {
    let res = await proxy.$api.user_info['get'](id);
    if(res.code == 0){
        form.value = Object.assign({}, res.data);
    }
    else{
        proxy.$modal.msgError(res.message);
    }
}

async function getDetailAll(id){
    let res = await proxy.$api.user_info_all['get'](id);
    if(res.code == 0){
        formAll.value = Object.assign({}, res.data);
    }
    else{
        proxy.$modal.msgError(res.message);
    }
}

function refresh(){
    if(routerQuery.userInfoId){
        getDetail(routerQuery.userInfoId);
    }
    if(detail.value == 'all'){
        if(routerQuery.userInfoId){
            getDetailAll(routerQuery.userInfoId);
        }
    }
}

refresh();

</script>

<style lang="scss" scoped></style>