<template>
  <base-wrapper
>
<base-header>
<search-operation
firstSearchComment="标题"
:searchData="listQuery"
@refreshTableData="refreshTableData"
@addEvent="handleAdd"
firstSearchData="bugTitle"
>
<template #collapse>
    <el-form-item v-show="!props.params.bugDiscoverer"  label="BUG发现人" prop="bugDiscoverer">
        <base-select clearable v-model="listQuery.bugDiscoverer" api="bug_info_all.get_user_info_list"></base-select>
    </el-form-item>

    <el-form-item v-show="!props.params.bugSubmitter"  label="BUG提交人" prop="bugSubmitter">
        <base-select clearable v-model="listQuery.bugSubmitter" api="bug_info_all.get_user_info_list"></base-select>
    </el-form-item>

    <el-form-item v-show="!props.params.bugHandler"  label="BUG处理人" prop="bugHandler">
        <base-select clearable v-model="listQuery.bugHandler" api="bug_info_all.get_user_info_list"></base-select>
    </el-form-item>

    <el-form-item  label="标题" prop="bugTitle">
        <el-input clearable placeholder="请输入标题" v-model="listQuery.bugTitle" />
    </el-form-item>

    <el-form-item  label="描述" prop="bugDescription">
        <el-input clearable placeholder="请输入描述" v-model="listQuery.bugDescription" />
    </el-form-item>

    <el-form-item  label="问题图片" prop="bugImage">
        <el-input clearable placeholder="请输入问题图片" v-model="listQuery.bugImage" />
    </el-form-item>

    <el-form-item v-show="!props.params.projectInfoId"  label="项目名称" prop="projectInfoId">
        <base-select clearable v-model="listQuery.projectInfoId" api="bug_info_all.get_project_info_list"></base-select>
    </el-form-item>

    <el-form-item   label="截止时间" prop="bugDeadline">
        <el-date-picker placeholder="请输入截止时间" v-model="listQuery.bugDeadline" type="date"
         format="YYYY-MM-DD" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item v-show="!props.params.bugPriority"  label="优先级" prop="bugPriority">
        <base-select clearable v-model="listQuery.bugPriority" api="bug_info_all.get_bug_priority_status_list"></base-select>
    </el-form-item>

    <el-form-item v-show="!props.params.bugHandleStatus"  label="审核状态" prop="bugHandleStatus">
        <base-select clearable v-model="listQuery.bugHandleStatus" api="bug_info_all.get_bug_handle_status_list"></base-select>
    </el-form-item>

    <el-form-item   label="创建时间" prop="createdTime">
        <el-date-picker placeholder="请输入创建时间" v-model="listQuery.createdTime" type="date"
         format="YYYY-MM-DD" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

</template>
</search-operation>
</base-header>
<base-table-p
ref="baseTableRef"
:params="listQuery"
api="bug_info_all.page"
>
<el-table-column
prop="bugInfoId"
label="编号"
align="center"
>

</el-table-column>
<el-table-column
prop="bugTitle"
label="标题"
align="center"
>

</el-table-column>
<el-table-column
prop="bugDescription"
label="描述"
align="center"
>

</el-table-column>
<el-table-column
prop="bugImage"
label="问题图片"
align="center"
>
<template #default="scope">
<image-preview
:height="50"
:src="scope.row.bugImage"
:width="50"
/>
</template>
</el-table-column>
<el-table-column
prop="bugDeadline"
label="截止时间"
align="center"
>
<template #default="scope">
{{ parseTime(scope.row.bugDeadline,'{y}-{m}-{d}') }}
</template>
</el-table-column>
<el-table-column
prop="createdTime"
label="创建时间"
align="center"
>
<template #default="scope">
{{ parseTime(scope.row.createdTime,'{y}-{m}-{d}') }}
</template>
</el-table-column>
<el-table-column
prop="userName"
label="BUG发现人"
align="center"
>

</el-table-column>
<el-table-column
prop="userNameUi1"
label="BUG提交人"
align="center"
>

</el-table-column>
<el-table-column
prop="userNameUi2"
label="BUG处理人"
align="center"
>

</el-table-column>
<el-table-column
prop="handleStatusDescription"
label="审核状态"
align="center"
>

</el-table-column>
<el-table-column
prop="priorityStatusDescription"
label="优先级"
align="center"
>

</el-table-column>
<el-table-column
prop="projectName"
label="项目名称"
align="center"
>

</el-table-column>
<el-table-column
width="220"
fixed="right"
label="操作"
align="center"
>
<template #default="scope">
<base-info-btn
path="/bug_info/detail"
:query="{bugInfoId: scope.row.bugInfoId}"
text="详情"
>
</base-info-btn>
<base-edit-btn
@ok="handleUpdate(scope.row)"
>
</base-edit-btn>
<base-delete-btn
@ok="handleDelete(scope.row)"
></base-delete-btn>
</template>
</el-table-column>
</base-table-p>
<base-dialog
v-if="dialogVisible"
:title="dialogTitleObj[dialogStatus]"
width="50%"
style="max-width: 600px;"
v-model="dialogVisible"
>
<el-form
ref='dataFormRef'
v-if='dialogStatus !== "detail"'
:model='form'
label-position='top'
:rules='{"bugPriority":[{"trigger":"blur","message":"优先级不能为空","required":true}],"bugTitle":[{"trigger":"blur","message":"标题不能为空","required":true}],"bugHandleStatus":[{"trigger":"blur","message":"审核状态不能为空","required":true}]}'
label-width='100px'
>
    <el-form-item v-show="!props.params.bugDiscoverer"  label="BUG发现人" prop="bugDiscoverer">
        <base-select clearable v-model="form.bugDiscoverer" api="bug_info_all.get_user_info_list"></base-select>
    </el-form-item>

    <el-form-item v-show="!props.params.bugSubmitter"  label="BUG提交人" prop="bugSubmitter">
        <base-select clearable v-model="form.bugSubmitter" api="bug_info_all.get_user_info_list"></base-select>
    </el-form-item>

    <el-form-item v-show="!props.params.bugHandler"  label="BUG处理人" prop="bugHandler">
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

    <el-form-item v-show="!props.params.projectInfoId"  label="项目名称" prop="projectInfoId">
        <base-select clearable v-model="form.projectInfoId" api="bug_info_all.get_project_info_list"></base-select>
    </el-form-item>

    <el-form-item   label="截止时间" prop="bugDeadline">
        <el-date-picker placeholder="请输入截止时间" v-model="form.bugDeadline" type="date"
         format="YYYY-MM-DD" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item v-show="!props.params.bugPriority"  label="优先级" prop="bugPriority">
        <base-select clearable v-model="form.bugPriority" api="bug_info_all.get_bug_priority_status_list"></base-select>
    </el-form-item>

    <el-form-item v-show="!props.params.bugHandleStatus"  label="审核状态" prop="bugHandleStatus">
        <base-select clearable v-model="form.bugHandleStatus" api="bug_info_all.get_bug_handle_status_list"></base-select>
    </el-form-item>

    <el-form-item   label="创建时间" prop="createdTime">
        <el-date-picker placeholder="请输入创建时间" v-model="form.createdTime" type="date"
         format="YYYY-MM-DD" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

</el-form>
<base-cell
v-else
label-width="100px"
>
<base-cell-item
label="编号"
>
{{ form.bugInfoId }}
</base-cell-item>
<base-cell-item
label="BUG发现人"
>
{{ form.bugDiscoverer }}
</base-cell-item>
<base-cell-item
label="BUG提交人"
>
{{ form.bugSubmitter }}
</base-cell-item>
<base-cell-item
label="BUG处理人"
>
{{ form.bugHandler }}
</base-cell-item>
<base-cell-item
label="标题"
>
{{ form.bugTitle }}
</base-cell-item>
<base-cell-item
label="描述"
>
{{ form.bugDescription }}
</base-cell-item>
<base-cell-item
label="问题图片"
>
{{ form.bugImage }}
</base-cell-item>
<base-cell-item
label="项目名称"
>
{{ form.projectInfoId }}
</base-cell-item>
<base-cell-item
label="截止时间"
>
{{ form.bugDeadline }}
</base-cell-item>
<base-cell-item
label="优先级"
>
{{ form.bugPriority }}
</base-cell-item>
<base-cell-item
label="审核状态"
>
{{ form.bugHandleStatus }}
</base-cell-item>
<base-cell-item
label="创建时间"
>
{{ form.createdTime }}
</base-cell-item>
</base-cell>
<template #footer>
<el-button
@click="dialogVisible = false"
round
>取 消</el-button>
<el-button
@click="submitForm"
round
color="#5D5FEF"
type="primary"
>确 定</el-button>
</template>
</base-dialog>
</base-wrapper>
</template>

<script setup>
const { proxy } = getCurrentInstance();

const props = defineProps({
    params: { type: Object, default: () => ({}) },
})

// 计算属性，用于判断 params 的长度
const paramsLength = computed(() =>  Object.keys(props.params).length)

// 计算属性，判断 params 是否为空
const isParamsEmpty = computed(() => paramsLength.value === 0)

let listQuery = ref({});
let form = ref({});
let dialogVisible = ref(false);
let dialogStatus = ref('');
let dialogTitleObj = ref({ update: '编辑', add: '添加', detail: '详情'});
let rules = ref({});
if(isParamsEmpty.value){
  let routerQuery = proxy.$route.query;
  Object.assign(listQuery.value, routerQuery);
}
else{
  Object.assign(listQuery.value, props.params);
}


function refreshTableData() {
  proxy.$refs.baseTableRef.refresh();
}
function handleDetail(row) {
  form.value = Object.assign({}, row);
  dialogStatus.value = 'detail';
  dialogVisible.value = true;
}
function handleAdd() {
  form.value = { ...props.params };
  dialogStatus.value = 'add';
  dialogVisible.value = true;
}
function handleUpdate(row) {
  form.value = Object.assign({}, row);
  dialogStatus.value = 'update';
  dialogVisible.value = true;
}
async function handleDelete(row) {
  let res = await proxy.$api.bug_info.delete(row.bugInfoId);
  refreshTableData();
  proxy.$modal.msgSuccess(res.message);
}
function submitForm() {
  if(dialogStatus.value == 'detail'){
      dialogVisible.value = false;
  }
  else {
      proxy.$refs.dataFormRef.validate(async (valid) => {
        if (valid) {
          let res = await proxy.$api.bug_info[dialogStatus.value](form.value);
          proxy.$modal.msgSuccess(res.message);
          refreshTableData();
          dialogVisible.value = false;
        }
      });
  }
}

function choose(item){
    form.value = Object.assign({}, item);
    dialogVisible.value = true;
    dialogStatus.value = 'update';
}
</script>

<style lang="scss" scoped></style>