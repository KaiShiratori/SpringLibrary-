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
            <el-button type="success" @click="addLibrary">追加</el-button>
          </el-col>
        </el-row>
      </el-card>
    </el-col>
    <el-col :span="24">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>図書一覧</span>
        </div>
        <el-table :data="libraryes" style="width: 100%">
          <el-table-column prop="id" label="ID" width="100" />
          <el-table-column prop="name" label="図書名" width="200" />
          <el-table-column prop="status" label="ステータス" width="100" />
          <el-table-column prop="startDate" label="貸出日" width="300" />
          <el-table-column
            prop="operation"
            label="更新ボタン"
            width="200"
            align="left"
          >
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="danger"
                @click="GoUpdate(scope.row.id)"
                >更新
              </el-button>
            </template>
          </el-table-column>
          <el-table-column
            prop="operation"
            label="削除ボタン"
            width="200"
            align="left"
          >
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="danger"
                @click="deleteLibrary(scope.row.id)"
                >x
              </el-button>
            </template>
          </el-table-column>
        </el-table>
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
        name: undefined,
        status: undefined,
        startDate: undefined
      },
      libraryes: []
    }
  },
  created: async function () {
    await this.refresh()
  },
  methods: {
    refresh: async function () {
      const res = await axios.get('http://localhost:8080/api/list')
      console.info(res.data)
      this.libraryes = res.data
    },
    addLibrary: async function () {
      await axios.post('http://localhost:8080/api/create', this.request)
      await this.refresh()
      // Element-UIのメッセージ表示
      this.$message({
        showClose: true,
        message: '追加完了！',
        type: 'success'
      })
    },
    deleteLibrary: async function (id) {
      await axios.post('http://localhost:8080/api/delete/' + id)
      await this.refresh()
      this.$message({
        showClose: true,
        message: '削除完了!',
        type: 'success'
      })
    },
    GoUpdate: async function (id) {
      this.$router.push({ path: '/update', query: { ID: id } })
    }
  }
}
</script>

<style scoped lang="scss">
@import "../styles/base";
</style>
