<template>
  <div class="product">
    제품 목록
    <ul v-if="productList && productList.length">
      <li v-for="(product, i) of productList" :key="i">
        {{product.number}}
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
      productList: []
    }
  },
  created () {           // 초기화 함수를 정의 한다.
    axios.get('http://127.0.0.1:8080/product/VehicleProduct')
        .then(response => {
          this.productList = response.data.result
        })
        .catch(e => {
          console.log('error : ', e)
        })
  }
}
</script>

