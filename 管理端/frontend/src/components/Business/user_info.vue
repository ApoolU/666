<template>
  <base-wrapper
>
<base-header>
<search-operation
firstSearchComment="姓名"
:searchData="listQuery"
@refreshTableData="refreshTableData"
@addEvent="handleAdd"
firstSearchData="userName"
>
<template #collapse>
    <el-form-item  label="姓名" prop="userName">
        <el-input clearable placeholder="请输入姓名" v-model="listQuery.userName" />
    </el-form-item>

    <el-form-item  label="手机号" prop="phoneNumber">
        <el-input clearable placeholder="请输入手机号" v-model="listQuery.phoneNumber" />
    </el-form-item>

    <el-form-item v-show="!props.params.technicalDirection"  label="技术方向" prop="technicalDirection">
        <base-select clearable v-model="listQuery.technicalDirection" api="user_info_all.get_technical_direction_status_list"></base-select>
    </el-form-item>

</template>
</search-operation>
</base-header>
<base-table-p
ref="baseTableRef"
:params="listQuery"
api="user_info_all.page"
>
<el-table-column
prop="userInfoId"
label="编号"
align="center"
>

</el-table-column>
<el-table-column
prop="userName"
label="姓名"
align="center"
>

</el-table-column>
<el-table-column
prop="phoneNumber"
label="手机号"
align="center"
>

</el-table-column>
<el-table-column
prop="technicalStatusDescription"
label="技术方向"
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
path="/user_info/detail"
:query="{userInfoId: scope.row.userInfoId}"
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
:rules='{"userName":[{"trigger":"blur","message":"姓名不能为空","required":true}],"technicalDirection":[{"trigger":"blur","message":"技术方向不能为空","required":true}]}'
label-width='100px'
>
    <el-form-item  label="姓名" prop="userName">
        <el-input clearable placeholder="请输入姓名" v-model="form.userName" />
    </el-form-item>

    <el-form-item  label="手机号" prop="phoneNumber">
        <el-input clearable placeholder="请输入手机号" v-model="form.phoneNumber" />
    </el-form-item>

    <el-form-item v-show="!props.params.technicalDirection"  label="技术方向" prop="technicalDirection">
        <base-select clearable v-model="form.technicalDirection" api="user_info_all.get_technical_direction_status_list"></base-select>
    </el-form-item>

</el-form>
<base-cell
v-else
label-width="100px"
>
<base-cell-item
label="编号"
>
{{ form.userInfoId }}
</base-cell-item>
<base-cell-item
label="姓名"
>
{{ form.userName }}
</base-cell-item>
<base-cell-item
label="手机号"
>
{{ form.phoneNumber }}
</base-cell-item>
<base-cell-item
label="技术方向"
>
{{ form.technicalDirection }}
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
  let res = await proxy.$api.user_info.delete(row.userInfoId);
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
          let res = await proxy.$api.user_info[dialogStatus.value](form.value);
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