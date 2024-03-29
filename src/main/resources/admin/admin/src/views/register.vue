<template>
  <div>
    <img class="bg" src="@/assets/img/bg.jpg">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="login-form">
      <h1 class="h1">金融管理系统注册</h1>
                              <el-form-item v-if="tableName=='huiyuan'" label="昵称" prop="huiyuannicheng">
        <el-input v-model="ruleForm.nicheng" placeholder="昵称"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='huiyuan'" label="密码" prop="huiyuanmima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='huiyuan'" label="姓名" prop="huiyuanxingming">
        <el-input v-model="ruleForm.xingming" placeholder="姓名"></el-input>
      </el-form-item>
                                                            <el-form-item v-if="tableName=='huiyuan'" label="手机" prop="huiyuanshouji">
        <el-input v-model="ruleForm.shouji" placeholder="手机"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='huiyuan'" label="生日" prop="huiyuanshengri">
        <el-input v-model="ruleForm.shengri" placeholder="生日"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='huiyuan'" label="身份证" prop="huiyuanshenfenzheng">
        <el-input v-model="ruleForm.shenfenzheng" placeholder="身份证"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='huiyuan'" label="地址" prop="huiyuandizhi">
        <el-input v-model="ruleForm.dizhi" placeholder="地址"></el-input>
      </el-form-item>
                                                                                                                                                      <el-button @click="login()" class="btn-login" type="primary">注册</el-button>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
              },
      tableName:"",
      rules: {}
    };
  },
  mounted(){
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 注册
    login() {
                                                                                                                                                                                                                                                                                                if(`huiyuan` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入电话格式`);
        return
      }
                                                                                                                        if(`huiyuan` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
                                                                                                                                                                                                            this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `${this.tableName}/register`,
            method: "post",
            data:this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$router.replace({ path: "/login" });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
