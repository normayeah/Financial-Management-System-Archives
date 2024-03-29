<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-row>
                  <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="产品名称" prop="chanpinmingcheng">
          <el-input v-model="ruleForm.chanpinmingcheng" 
              placeholder="产品名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.chanpinmingcheng" label="产品名称" prop="chanpinmingcheng">
              <el-input v-model="ruleForm.chanpinmingcheng" 
                placeholder="产品名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="类型" prop="leixing">
          <el-input v-model="ruleForm.leixing" 
              placeholder="类型" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.leixing" label="类型" prop="leixing">
              <el-input v-model="ruleForm.leixing" 
                placeholder="类型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="产品价格" prop="chanpinjiage">
          <el-input v-model="ruleForm.chanpinjiage" 
              placeholder="产品价格" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.chanpinjiage" label="产品价格" prop="chanpinjiage">
              <el-input v-model="ruleForm.chanpinjiage" 
                placeholder="产品价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="购买日期" prop="goumairiqi">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.goumairiqi" 
                type="date"
                placeholder="购买日期">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.goumairiqi" label="购买日期" prop="goumairiqi">
              <el-input v-model="ruleForm.goumairiqi" 
                placeholder="购买日期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="昵称" prop="nicheng">
          <el-input v-model="ruleForm.nicheng" 
              placeholder="昵称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.nicheng" label="昵称" prop="nicheng">
              <el-input v-model="ruleForm.nicheng" 
                placeholder="昵称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming" 
              placeholder="姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xingming" label="姓名" prop="xingming">
              <el-input v-model="ruleForm.xingming" 
                placeholder="姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji" 
              placeholder="手机" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shouji" label="手机" prop="shouji">
              <el-input v-model="ruleForm.shouji" 
                placeholder="手机" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="身份证" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng" 
              placeholder="身份证" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shenfenzheng" label="身份证" prop="shenfenzheng">
              <el-input v-model="ruleForm.shenfenzheng" 
                placeholder="身份证" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="备注" prop="beizhu">
          <el-input v-model="ruleForm.beizhu" 
              placeholder="备注" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.beizhu" label="备注" prop="beizhu">
              <el-input v-model="ruleForm.beizhu" 
                placeholder="备注" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                        </el-row>
                                                                                                                                                                                                                                                                                                                                                                  <el-form-item>
                <el-button v-if="type!='info'" type="primary" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',
      ruleForm: {
                        chanpinmingcheng: '',
                                leixing: '',
                                chanpinjiage: '',
                                goumairiqi: '',
                                nicheng: '',
                                xingming: '',
                                shouji: '',
                                shenfenzheng: '',
                                beizhu: '',
                                sfsh: '',
                                shhf: '',
                                ispay: '',
                      },
                                                                                                                                                                                    rules: {
                  chanpinmingcheng: [
                                                                                              ],
                  leixing: [
                                                                                              ],
                  chanpinjiage: [
                                                                                              ],
                  goumairiqi: [
                                                                                              ],
                  nicheng: [
                                                                                              ],
                  xingming: [
                                                                                              ],
                  shouji: [
                                                                                              ],
                  shenfenzheng: [
                                                                                              ],
                  beizhu: [
                                                                                              ],
                  sfsh: [
                                                                                              ],
                  shhf: [
                                                                                              ],
                  ispay: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                                                                      },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
                    if(o=='chanpinmingcheng'){
            this.ruleForm.chanpinmingcheng = obj[o];
            continue;
          }
                    if(o=='leixing'){
            this.ruleForm.leixing = obj[o];
            continue;
          }
                    if(o=='chanpinjiage'){
            this.ruleForm.chanpinjiage = obj[o];
            continue;
          }
                    if(o=='goumairiqi'){
            this.ruleForm.goumairiqi = obj[o];
            continue;
          }
                    if(o=='nicheng'){
            this.ruleForm.nicheng = obj[o];
            continue;
          }
                    if(o=='xingming'){
            this.ruleForm.xingming = obj[o];
            continue;
          }
                    if(o=='shouji'){
            this.ruleForm.shouji = obj[o];
            continue;
          }
                    if(o=='shenfenzheng'){
            this.ruleForm.shenfenzheng = obj[o];
            continue;
          }
                    if(o=='beizhu'){
            this.ruleForm.beizhu = obj[o];
            continue;
          }
                    if(o=='sfsh'){
            this.ruleForm.sfsh = obj[o];
            continue;
          }
                    if(o=='shhf'){
            this.ruleForm.shhf = obj[o];
            continue;
          }
                    if(o=='ispay'){
            this.ruleForm.ispay = obj[o];
            continue;
          }
                  }
                                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                            this.ruleForm.nicheng = json.nicheng
                                                this.ruleForm.xingming = json.xingming
                                                this.ruleForm.shouji = json.shouji
                                                this.ruleForm.shenfenzheng = json.shenfenzheng
                                                                                                                      } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                                                                                                      },
                                                                                                        // 多级联动参数
                                                                                                                                    info(id) {
      this.$http({
        url: `licaigoumai/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                                                                                                                                                                                                                                                                                                                  this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `licaigoumai/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.licaigoumaiCrossAddOrUpdateFlag = false;
                  this.parent.search();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.licaigoumaiCrossAddOrUpdateFlag = false;
    },
                                                                                                                                                      }
};
</script>
<style lang="scss" scoped>
.editor{
  height: 500px;
}
</style>
