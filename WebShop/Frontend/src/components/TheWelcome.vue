
<template>
  <section class="welcome">
    <h2>Welcome to Chocolate Factory project!</h2>

    <!--
    <div>
      <RouterLink to="/login">Login</RouterLink>
    </div>
    -->
    <div>
        <h1>Login</h1>
        <form class="login-component" @submit.prevent="login">
            <div>
                <label for="username">Username:</label>
                <input type="text" id="username" v-model="username" required>
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" v-model="password" required>
            </div>
            <button class="submit" type="submit">Login</button>

            <br>

            <p id="success">{{ success }}</p>
            <p id="error">{{ errorMessage }}</p>
        </form>
    </div>
    <!--
    <div>
      <RouterLink to="/webshop">WebShop</RouterLink>
    </div>
    -->
    
    <div id="web-shop">
      <h1>Table</h1>
      <div id="products">
        <h3>{{ title }}</h3>

        <table id="tabela">
          <thead>
            <tr>
              <th>Id</th>
              <th>Logo</th>
              <th>Naziv</th>
              <th>Lokacija</th>
              <th>Prosecna cena</th>
            </tr>
          </thead>

          <tr v-for="f in factories">
            <td>{{ f.id }}</td>
            <td><img width="50" height="50" :src ="f.logo"></td>
            <td>{{ f.name }}</td>
            <td>{{ f.locationStr}}</td>
            <td>{{ f.grade }}</td>
          </tr>
        </table>
      </div>
    </div>

  </section>
</template>


<script setup>
import axios from 'axios';
import {onMounted,ref } from 'vue';



const username = ref('');
const password = ref('');

const errorMessage = ref('');
const success = ref('');
const title = ref("Factories:");
const factories = ref([]);
const mode = ref("BROWSE");
const error = ref("");
const selectedProduct = ref({ name: "", price: 0 });

const login = () => {
    axios.post('http://localhost:8080/WebShopAppREST/rest/login', { username: username.value, password: password.value })
        .then(response => {
            success.value = 'Korisnik je uspesno prijavljen.';
            errorMessage.value = '';
        })
        .catch(error => {
            success.value = '';
            errorMessage.value = 'Pogresno korisnicko ime ili lozinka.';
            console.error(error);
        });
}


onMounted(() => {
	loadProducts();
})

function loadProducts() {
	axios.get('http://localhost:8080/WebShopAppREST/rest/factories/')
		.then(response => {
			      factories.value = response.data;
            // Sortiranje fabrika po statusu otvorenosti
            factories.value.sort((a, b) => {
                if (a.status === 'Open' && b.status === 'Closed') {
                    return -1; // Ako je a otvorena, pre b
                } else if (a.status === 'Closed' && b.status === 'Open') {
                    return 1; // Ako je b otvorena, pre a
                } else {
                    return 0; // Ako su oba istog statusa, zadrži trenutni redosled
                }
            });
		});
}

</script>

<style scoped>
.login-component {
    display: flex;
    flex-direction: column;
    gap: 1rem;
    margin: 0 auto;
    width: 400px;
}

.login-component label {
    font-weight: bold;
    display: block;
}

.login-component input {
    padding: 0.5rem;
    border: 1px solid #797979;
    border-radius: 0.25rem;
    background-color: #555555;
    color: white;
    display: block;
    width: 100%;
}

.login-component>.submit {
    padding: 0.5rem;
    border: none;
    border-radius: 0.25rem;
    background-color: #007bff;
    color: white;
    cursor: pointer;
}

.login-component>.submit:hover {
    background-color: #0056b3;
}

p {
    display: block;
}
#web-shop {
	width: 600px;
}

#tabela {
	color: white;
	background-color: #333;
	border-collapse: collapse;
	width: 100%;
}

#tabela th,
#tabela td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

#tabela th {
	background-color: #555;
}

#tabela tr:nth-child(even) {
	background-color: #444;
}

#tabela tr:hover {
	background-color: #777;
}

.dodaj {
	padding: 8px;
	border: none;
	border-radius: 0.25rem;
	background-color: #007bff;
	color: white;
}
</style>

