<template>
  <base-wrapper
>
<base-header>
<search-operation
firstSearchComment="项目名称"
:searchData="listQuery"
@refreshTableData="refreshTableData"
@addEvent="handleAdd"
firstSearchData="projectName"
>
<template #collapse>
    <el-form-item  label="项目名称" prop="projectName">
        <el-input clearable placeholder="请输入项目名称" v-model="listQuery.projectName" />
    </el-form-item>

    <el-form-item  label="项目版本" prop="projectVersion">
        <el-input clearable placeholder="请输入项目版本" v-model="listQuery.projectVersion" />
    </el-form-item>

    <el-form-item v-show="!props.params.projectLeader"  label="负责人" prop="projectLeader">
        <base-select clearable v-model="listQuery.projectLeader" api="project_info_all.get_user_info_list"></base-select>
    </el-form-item>

</template>
</search-operation>
</base-header>
<base-table-p
ref="baseTableRef"
:params="listQuery"
api="project_info_all.page"
>
<el-table-column
prop="projectInfoId"
label="编号"
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
prop="projectVersion"
label="项目版本"
align="center"
>

</el-table-column>
<el-table-column
prop="userName"
label="负责人"
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
path="/project_info/detail"
:query="{projectInfoId: scope.row.projectInfoId}"
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
:rules='{"projectName":[{"trigger":"blur","message":"项目名称不能为空","required":true}]}'
label-width='100px'
>
    <el-form-item  label="项目名称" prop="projectName">
        <el-input clearable placeholder="请输入项目名称" v-model="form.projectName" />
    </el-form-item>

    <el-form-item  label="项目版本" prop="projectVersion">
        <el-input clearable placeholder="请输入项目版本" v-model="form.projectVersion" />
    </el-form-item>

    <el-form-item v-show="!props.params.projectLeader"  label="负责人" prop="projectLeader">
        <base-select clearable v-model="form.projectLeader" api="project_info_all.get_user_info_list"></base-select>
    </el-form-item>

</el-form>
<base-cell
v-else
label-width="100px"
>
<base-cell-item
label="编号"
>
{{ form.projectInfoId }}
</base-cell-item>
<base-cell-item
label="项目名称"
>
{{ form.projectName }}
</base-cell-item>
<base-cell-item
label="项目版本"
>
{{ form.projectVersion }}
</base-cell-item>
<base-cell-item
label="负责人"
>
{{ form.projectLeader }}
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
  let res = await proxy.$api.project_info.delete(row.projectInfoId);
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
          let res = await proxy.$api.project_info[dialogStatus.value](form.value);
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