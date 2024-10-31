import request from '@/utils/request';

const BASE_API = "/userInfoAll";

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

get_technical_direction_status_list(){
  return request({
    url: BASE_API + "/get/technical_direction_status_list",
    method: "get"
  });
},


};
