<template>
  <div class="product">
    제품 목록
    <ul v-if="toDoItems && toDoItems.length">
      <li v-for="(toDoItem, i) of toDoItems" :key="i">
        {{toDoItem.number}}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'product',
  data: () => {
    return {
      toDoItems: []
    }
  },
  created () {           // 초기화 함수를 정의 한다.
    axios.get('http://127.0.0.1:8080/product/VehicleProduct')
        .then(response => {
          this.toDoItems = response.data.result
        })
        .catch(e => {
          console.log('error : ', e)
        })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #35495E;
}
</style>
