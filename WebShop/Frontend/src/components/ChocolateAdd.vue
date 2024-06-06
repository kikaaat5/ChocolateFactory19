<template>
    <h1>Update Čokolade</h1>
    <form v-on:submit="saveChocolate($event)">
        <div class="form-group">
            <label for="name">Naziv:</label>
            <input type="text" id="name" name="name" v-model="c.name" required>
        </div>
        <div class="form-group">
            <label for="price">Cena:</label>
            <input type="number" id="price" name="price" v-model="c.price" required>
        </div>
        <div class="form-group">
            <label for="type">Vrsta:</label>
            <select id="type" name="type" v-model="c.species" required>
                <option value="mlecna">Mlečna</option>
                <option value="crna">Crna</option>
                <option value="bela">Bela</option>
            </select>
        </div>
        <div class="form-group">
            <label for="category">Tip:</label>
            <select id="category" name="category" v-model="c.type" required>
                <option value="obicna">Tab</option>
                <option value="za kuvanje">Bar</option>
                <option value="za pice">Truffle</option>
            </select>
        </div>
        <div class="form-group">
            <label for="weight">Gramaža:</label>
            <input type="number" id="weight" name="weight" v-model="c.weight" required>
        </div>
        <div class="form-group">
            <label for="description">Opis:</label>
            <textarea id="description" name="description" v-model="c.description" required></textarea>
        </div>
        <div class="form-group">
            <label for="image">Slika:</label>
            <td>
               <input type="text" v-model="c.image" :class="{ 'error' : !validation.imageValid}"/>
                <p style="color: red">{{ errorMessages.imageError }}</p>
            </td>        </div>
        <button type="submit">Sačuvaj</button>
    </form>



</template>

<script setup>
import axios from 'axios';
import { onMounted, ref, computed } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const router = useRouter()

const c = ref({id:"", name:"", price: 0.0, species : "",factoryId: "" ,category:"", type:"", weight: 0.0, description:"", image:"", status:""})


onMounted(()=>{
})



function saveChocolate(event){
    event.preventDefault();
    axios.put('http://localhost:8080/WebShopAppREST/rest/chocolates/add' this.chocolate).then(response=>{
        push.back();
    });
}


</script>