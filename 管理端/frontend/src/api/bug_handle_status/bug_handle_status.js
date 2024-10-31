import request from '@/utils/request';

const BASE_API = "/bugHandleStatus";

export default {
  page(query) {
    return request({
      url: BASE_API + "/page",
      method: "post",
      data: query
    });
  },
  get(id){
    return request({
      url: BASE_API + "/get/" + id,
      method: "get"
    });
  },
  add(data) {
    return request({
      url: BASE_API + "/add",
      method: "post",
      data: data
    });
  },
  update(data) {
    return request({
      url: BASE_API + "/update",
      method: "put",
      data: data
    });
  },
  delete(id) {
    return request({
      url: BASE_API + "/delete/" + id,
      method: "delete"
    });
  },
  get_select_list() {
    return request({
      url: BASE_API + "/get_select_list",
      method: "post"
    });
  }
};
