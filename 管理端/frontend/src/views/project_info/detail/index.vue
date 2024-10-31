<template>
  <base-wrapper
>
<div class="flex-between-start" style="background-color: #5D5FEF; height: 140px;">
    <div class="flex-c-center-start h-full">
      <div class="m-x-20">
          <span style="font-weight: bold; font-size: 20px; color: #FFFFFF;">项目信息管理</span>
      </div>
      <div class="m-x-20 m-t-4">
        <span style="font-size: 14px; color: #FFFFFF;">编号、项目名称、项目版本、负责人。</span>
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
:to="{ path: '/project_info' }"
>
项目信息管理
</el-breadcrumb-item>
<el-breadcrumb-item
>
项目信息详情
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
label="项目信息详情"
>
<el-form
:model='form'
ref='dataFormRef'
label-position='top'
:rules='{"projectName":[{"trigger":"blur","message":"项目名称不能为空","required":true}]}'
label-width='150px'
>
    <el-form-item  label="项目名称" prop="projectName">
        <el-input clearable placeholder="请输入项目名称" v-model="form.projectName" />
    </el-form-item>

    <el-form-item  label="项目版本" prop="projectVersion">
        <el-input clearable placeholder="请输入项目版本" v-model="form.projectVersion" />
    </el-form-item>

    <el-form-item   label="负责人" prop="projectLeader">
        <base-select clearable v-model="form.projectLeader" api="project_info_all.get_user_info_list"></base-select>
    </el-form-item>

</el-form>
<base-cell
header="所属用户"
label-width="180px"
class="m-b-10"
>
<base-cell-item
label="姓名"
>
{{ formAll.userName }}
</base-cell-item>
<base-cell-item
label="手机号"
>
{{ formAll.phoneNumber }}
</base-cell-item>
<base-cell-item
label="技术方向"
>
{{ formAll.technicalDirection }}
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
 :params="{projectInfoId:routerQuery.projectInfoId}"
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
      let res = await proxy.$api.project_info['update'](form.value);
      proxy.$modal.msgSuccess(res.message);
      if(res.code == 0){
        refresh();
      }
    }
  });
}

async function getDetail(id) {
    let res = await proxy.$api.project_info['get'](id);
    if(res.code == 0){
        form.value = Object.assign({}, res.data);
    }
    else{
        proxy.$modal.msgError(res.message);
    }
}

async function getDetailAll(id){
    let res = await proxy.$api.project_info_all['get'](id);
    if(res.code == 0){
        formAll.value = Object.assign({}, res.data);
    }
    else{
        proxy.$modal.msgError(res.message);
    }
}

function refresh(){
    if(routerQuery.projectInfoId){
        getDetail(routerQuery.projectInfoId);
    }
    if(detail.value == 'all'){
        if(routerQuery.projectInfoId){
            getDetailAll(routerQuery.projectInfoId);
        }
    }
}

refresh();

</script>

<style lang="scss" scoped></style>