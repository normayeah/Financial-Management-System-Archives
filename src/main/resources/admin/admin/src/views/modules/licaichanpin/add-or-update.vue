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
        <el-form-item v-if="type!='info'"  label="类型" prop="leixing">
          <el-select v-model="ruleForm.leixing" placeholder="请选择类型">
            <el-option
                v-for="(item,index) in leixingOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.leixing" label="类型" prop="leixing">
              <el-input v-model="ruleForm.leixing" 
                placeholder="类型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="产品附图" prop="chanpinfutu">
          <file-upload
          tip="点击上传产品附图"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.chanpinfutu?ruleForm.chanpinfutu:''"
          @change="chanpinfutuUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.chanpinfutu" label="产品附图" prop="chanpinfutu">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.chanpinfutu.split(',')" :src="item" width="100" height="100">
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
                                                                                                                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="产品详情" prop="chanpinxiangqing">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.chanpinxiangqing" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.chanpinxiangqing" label="产品详情" prop="chanpinxiangqing">
                    <span v-html="ruleForm.chanpinxiangqing"></span>
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
                                chanpinfutu: '',
                                chanpinxiangqing: '',
                                chanpinjiage: '',
                                beizhu: '',
                      },
                                      leixingOptions: [],
                                                                            rules: {
                  chanpinmingcheng: [
                                                                                              ],
                  leixing: [
                                                                                              ],
                  chanpinfutu: [
                                                                                              ],
                  chanpinxiangqing: [
                                                                                              ],
                  chanpinjiage: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  beizhu: [
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
                    if(o=='chanpinfutu'){
            this.ruleForm.chanpinfutu = obj[o];
            continue;
          }
                    if(o=='chanpinxiangqing'){
            this.ruleForm.chanpinxiangqing = obj[o];
            continue;
          }
                    if(o=='chanpinjiage'){
            this.ruleForm.chanpinjiage = obj[o];
            continue;
          }
                    if(o=='beizhu'){
            this.ruleForm.beizhu = obj[o];
            continue;
          }
                  }
                                                                                                              }
                                                            this.$http({
              url: `option/chanpinleixing/leixing`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.leixingOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                                                                                    },
                                                        // 多级联动参数
                                                                        info(id) {
      this.$http({
        url: `licaichanpin/info/${id}`,
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
            url: `licaichanpin/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.licaichanpinCrossAddOrUpdateFlag = false;
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
      this.parent.licaichanpinCrossAddOrUpdateFlag = false;
    },
                                                chanpinfutuUploadChange(fileUrls) {
                this.ruleForm.chanpinfutu = fileUrls;
            },
                                                  }
};
</script>
<style lang="scss" scoped>
.editor{
  height: 500px;
}
</style>
