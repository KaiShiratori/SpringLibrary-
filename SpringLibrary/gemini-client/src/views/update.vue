<template>
  <el-row>
    <el-col :span="24">
      <el-card class="box-card box-card-wrapper">
        <div slot="header">
          <span>新規追加</span>
        </div>
        <el-row class="row-wrapper">
          <el-col :span="12">
            <span>新規図書名</span>
          </el-col>
          <el-col :span="12">
            <el-input
              v-model="request.name"
              placeholder="New Name..."
              clearable
            >
            </el-input>
          </el-col>
        </el-row>
        <el-row class="row-wrapper">
          <el-col :span="12">
            <span>ステータス</span>
          </el-col>
          <el-col :span="12">
            <el-input
              v-model.number="request.status"
              placeholder="貸し借り状況は..."
              clearable
            >
            </el-input>
          </el-col>
        </el-row>
        <el-row class="row-wrapper">
          <el-col :span="12">
            <span>貸出日</span>
          </el-col>
          <el-col :span="12">
            <el-date-picker
              v-model="request.startDate"
              placeholder="日時を選択してください"
              clearable
            >
            </el-date-picker>
          </el-col>
        </el-row>
        <el-row class="row-wrapper">
          <el-col :span="24">
            <el-button type="success" @click="DoUpdate">更新</el-button>
          </el-col>
        </el-row>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Library',
  data () {
    return {
      request: {
        id: undefined,
        name: undefined,
        status: undefined,
        startDate: undefined
      }
    }
  },
  created: async function () {
    const ID = this.$route.query.ID
    const res = await axios.get('http://localhost:8080/api/update/' + ID)
    console.info(res.data)
    this.request.id = res.data.id
    this.request.name = res.data.name
    this.request.status = res.data.status
    this.request.startDate = res.data.startDate
  },
  methods: {
    DoUpdate: async function () {
      await axios.post('http://localhost:8080/api/update', this.request)
      this.$router.push('/library')
    }
  }
}
</script>

<style scoped lang="scss">
@import "../styles/base";
</style>
