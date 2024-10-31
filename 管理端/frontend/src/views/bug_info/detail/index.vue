<template>
  <base-wrapper
>
<div class="flex-between-start" style="background-color: #5D5FEF; height: 140px;">
    <div class="flex-c-center-start h-full">
      <div class="m-x-20">
          <span style="font-weight: bold; font-size: 20px; color: #FFFFFF;">BUG管理</span>
      </div>
      <div class="m-x-20 m-t-4">
        <span style="font-size: 14px; color: #FFFFFF;">编号、BUG发现人、BUG提交人、BUG处理人、标题、描述、问题图片、项目名称、截止时间、优先级、审核状态、创建时间。</span>
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
:to="{ path: '/bug_info' }"
>
BUG管理
</el-breadcrumb-item>
<el-breadcrumb-item
>
BUG详情
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
label="BUG详情"
>
<el-form
:model='form'
ref='dataFormRef'
label-position='top'
:rules='{"bugPriority":[{"trigger":"blur","message":"优先级不能为空","required":true}],"bugTitle":[{"trigger":"blur","message":"标题不能为空","required":true}],"bugHandleStatus":[{"trigger":"blur","message":"审核状态不能为空","required":true}]}'
label-width='150px'
>
    <el-form-item   label="BUG发现人" prop="bugDiscoverer">
        <base-select clearable v-model="form.bugDiscoverer" api="bug_info_all.get_user_info_list"></base-select>
    </el-form-item>

    <el-form-item   label="BUG提交人" prop="bugSubmitter">
        <base-select clearable v-model="form.bugSubmitter" api="bug_info_all.get_user_info_list"></base-select>
    </el-form-item>

    <el-form-item   label="BUG处理人" prop="bugHandler">
        <base-select clearable v-model="form.bugHandler" api="bug_info_all.get_user_info_list"></base-select>
    </el-form-item>

    <el-form-item  label="标题" prop="bugTitle">
        <el-input clearable placeholder="请输入标题" v-model="form.bugTitle" />
    </el-form-item>

    <el-form-item  label="描述" prop="bugDescription">
        <el-input clearable placeholder="请输入描述" v-model="form.bugDescription" />
    </el-form-item>

    <el-form-item  label="问题图片" prop="bugImage">
        <image-upload v-model="form.bugImage"/>
    </el-form-item>

    <el-form-item   label="项目名称" prop="projectInfoId">
        <base-select clearable v-model="form.projectInfoId" api="bug_info_all.get_project_info_list"></base-select>
    </el-form-item>

    <el-form-item   label="截止时间" prop="bugDeadline">
        <el-date-picker placeholder="请输入截止时间" v-model="form.bugDeadline" type="date"
         format="YYYY-MM-DD" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="优先级" prop="bugPriority">
        <base-select clearable v-model="form.bugPriority" api="bug_info_all.get_bug_priority_status_list"></base-select>
    </el-form-item>

    <el-form-item   label="审核状态" prop="bugHandleStatus">
        <base-select clearable v-model="form.bugHandleStatus" api="bug_info_all.get_bug_handle_status_list"></base-select>
    </el-form-item>

    <el-form-item   label="创建时间" prop="createdTime">
        <el-date-picker placeholder="请输入创建时间" v-model="form.createdTime" type="date"
         format="YYYY-MM-DD" value-format="YYYY-MM-DD HH:mm:ss" />
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
<base-cell
header="所属用户"
label-width="180px"
class="m-b-10"
>
<base-cell-item
label="姓名"
>
{{ formAll.userNameUi1 }}
</base-cell-item>
<base-cell-item
label="手机号"
>
{{ formAll.phoneNumberUi1 }}
</base-cell-item>
<base-cell-item
label="技术方向"
>
{{ formAll.technicalDirectionUi1 }}
</base-cell-item>
</base-cell>
<base-cell
header="所属用户"
label-width="180px"
class="m-b-10"
>
<base-cell-item
label="姓名"
>
{{ formAll.userNameUi2 }}
</base-cell-item>
<base-cell-item
label="手机号"
>
{{ formAll.phoneNumberUi2 }}
</base-cell-item>
<base-cell-item
label="技术方向"
>
{{ formAll.technicalDirectionUi2 }}
</base-cell-item>
</base-cell>
<base-cell
header="所属BUG处理状态"
label-width="180px"
class="m-b-10"
>
<base-cell-item
label="状态描述"
>
{{ formAll.handleStatusDescription }}
</base-cell-item>
</base-cell>
<base-cell
header="所属BUG优先级"
label-width="180px"
class="m-b-10"
>
<base-cell-item
label="优先级描述"
>
{{ formAll.priorityStatusDescription }}
</base-cell-item>
</base-cell>
<base-cell
header="所属项目信息"
label-width="180px"
class="m-b-10"
>
<base-cell-item
label="项目名称"
>
{{ formAll.projectName }}
</base-cell-item>
<base-cell-item
label="项目版本"
>
{{ formAll.projectVersion }}
</base-cell-item>
<base-cell-item
label="负责人"
>
{{ formAll.projectLeader }}
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
      let res = await proxy.$api.bug_info['update'](form.value);
      proxy.$modal.msgSuccess(res.message);
      if(res.code == 0){
        refresh();
      }
    }
  });
}

async function getDetail(id) {
    let res = await proxy.$api.bug_info['get'](id);
    if(res.code == 0){
        form.value = Object.assign({}, res.data);
    }
    else{
        proxy.$modal.msgError(res.message);
    }
}

async function getDetailAll(id){
    let res = await proxy.$api.bug_info_all['get'](id);
    if(res.code == 0){
        formAll.value = Object.assign({}, res.data);
    }
    else{
        proxy.$modal.msgError(res.message);
    }
}

function refresh(){
    if(routerQuery.bugInfoId){
        getDetail(routerQuery.bugInfoId);
    }
    if(detail.value == 'all'){
        if(routerQuery.bugInfoId){
            getDetailAll(routerQuery.bugInfoId);
        }
    }
}

refresh();

</script>

<style lang="scss" scoped></style>