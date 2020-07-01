<template>
	<div id="app">
		<img src="./assets/logo.png">
		<div>
			<el-button @click="startHacking">fuck</el-button>
		</div>

		<el-table :data="tableData" stripe style="width: 100%" border>
			<el-table-column prop="index" label="">
			</el-table-column>
			<el-table-column prop="name" label="书籍名称">
			</el-table-column>
			<el-table-column prop="date" label="出版日期">
			</el-table-column>
			<el-table-column prop="price" label="价格">
			</el-table-column>
			
			<el-table-column label="购买数量">
				<template slot-scope="scope">
					<el-input-number v-model="num" @change="handleChange" :min="1" :max="10" label="描述文字"></el-input-number>
				</template>
			</el-table-column>

			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button size="mini" type="danger" @click="handleEdit(scope.$index, scope.row)">移除</el-button>
				</template>
			</el-table-column>



		</el-table>



	</div>




</template>

<script>
	export default {
		data() {
			return {
				num:1,
				tableData: [{
					index: 1,
					name: '《java从入门到放弃》',
					date: '2010-10',
					price: '￥60.00'
				}, {
					index: 2,
					name: '《php从入门到放弃》',
					date: '2012-10',
					price: '￥90.00'
				}, {
					index: 3,
					name: '《python从入门到放弃》',
					date: '2013-10',
					price: '￥80.00'
				}, {
					index: 4,
					name: '《什么都是从入门到放弃》',
					date: '2011-10',
					price: '￥70.00'
				}, ]
			}
		},
		methods: {
			startHacking() {
				this.$notify({
					title: 'It works!',
					type: 'success',
					message: 'We\'ve laid the ground work for you. It\'s time for you to build something epic!',
					duration: 5000
				})
			}
		}
	}
</script>

<style>
	#app {
		font-family: Helvetica, sans-serif;
		text-align: center;
	}
</style>
