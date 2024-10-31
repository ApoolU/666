import request from '@/utils/request';

const BASE_API = "/projectInfoAll";

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
  list(query) {
    return request({
      url: BASE_API + "/list",
      method: "post",
      data: query
    });
  },

get_user_info_list(){
  return request({
    url: BASE_API + "/get/user_info_list",
    method: "get"
  });
},


};
