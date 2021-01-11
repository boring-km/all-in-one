<template>
  <navbar
    position="fixed"
    type="primary"
    :transparent="transparent"
    :color-on-scroll="colorOnScroll"
    menu-classes="ml-auto"
  >
    <template>
      <router-link v-popover:popover1 class="navbar-brand" to="/">
        All in One
      </router-link>
      <el-popover
        ref="popover1"
        popper-class="popover"
        placement="bottom"
        width="200"
        trigger="hover"
      >
        <div class="popover-body">
          메인화면으로 돌아가기
        </div>
      </el-popover>
    </template>
    <template slot="navbar-menu">
      <drop-down
        tag="li"
        title="대여하기"
        icon="now-ui-icons design_app"
        class="nav-item"
      >
        <nav-link to="/">
          <i class="now-ui-icons el-icon-office-building"></i> 가정집
        </nav-link>
        <a
          href="https://demos.creative-tim.com/vue-now-ui-kit/documentation"
          target="_blank"
          class="dropdown-item"
        >
          <i class="now-ui-icons shopping_cart-simple"></i> 가게
        </a>
        <a
            href="https://demos.creative-tim.com/vue-now-ui-kit/documentation"
            target="_blank"
            class="dropdown-item"
        >
          <i class="now-ui-icons transportation_bus-front-12"></i> 차량
        </a>
      </drop-down>
      <!-- li class="nav-item">
        <a
          class="nav-link btn btn-neutral"
          href="https://www.creative-tim.com/product/vue-now-ui-kit-pro"
          target="_blank"
        >
          <i class="now-ui-icons arrows-1_share-66"></i>
          <p>Upgrade to PRO</p>
        </a>
      </li !-->

      <li class="nav-item">
        <a
          class="nav-link"
          rel="tooltip"
          title="Follow us on GitHub"
          data-placement="bottom"
          href="https://github.com/chaibin0/all-in-one"
          target="_blank"
        >
          <i class="fab fa-github"></i>
          <p class="d-lg-none d-xl-none">GitHub</p>
        </a>
      </li>
    </template>
  </navbar>
</template>

<script>
import { DropDown, Navbar, NavLink } from '@/components';
import { Popover } from 'element-ui';
export default {
  name: 'main-navbar',
  props: {
    transparent: Boolean,
    colorOnScroll: Number
  },
  components: {
    DropDown,
    Navbar,
    NavLink,
    [Popover.name]: Popover
  }
};
</script>

<style scoped></style>
