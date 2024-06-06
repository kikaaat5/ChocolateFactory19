<template>
    <div>
      <h1>Factory Details</h1>
      <p>{{ factory.name }}</p>
      <!-- Dodajte ostale detalje fabrike koje želite da prikažete -->
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const factory = ref(null);
  
  onMounted(() => {
    loadFactory();
  });
  
  function loadFactory() {
    const factoryId = $route.params.id;
    axios.get(`http://localhost:8080/WebShopAppREST/rest/factories/${factoryId}`)
      .then(response => {
        factory.value = response.data;
      })
      .catch(error => {
        console.error(error);
      });
  }
  </script>