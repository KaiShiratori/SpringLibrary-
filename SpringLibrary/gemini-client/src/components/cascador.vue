<template>
  <div>
    <br />
    <div class="block">
      <span class="demonstration">Child options expand when hoverd</span>
      <el-cascader
        v-model="value"
        :options="options"
        :props="{ expandTrigger: 'hover' }"
        @change="handleChange"
      ></el-cascader>
    </div>
  </div>
</template>

<script>
export default {
  name: 'abc',
  data () {
    return {
      datetime: '',
      color: '#20a0ff',
      value: [],
      options: [
        {
          value: 'あいうえお',
          label: 'ラベルA',
          children: [
            {
              value: '子1',
              label: '子1'
            },
            {
              value: '子2',
              label: '子2'
            }
          ]
        },
        {
          value: 'かきくけこ',
          label: 'ラベルB',
          children: [
            {
              value: '子3',
              label: '子3'
            },
            {
              value: '子4',
              label: '子4'
            }
          ]
        }
      ]
    }
  },
  methods: {
    handleChange (value) {
      console.log(value)
    }
  }
}
</script>
