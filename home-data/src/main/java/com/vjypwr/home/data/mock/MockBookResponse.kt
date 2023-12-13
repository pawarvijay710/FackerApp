package com.vjypwr.home.data.mock

import com.google.gson.Gson
import com.vjypwr.home.data.model.response.book.BookResponse

class MockBookResponse {
    fun getBookResponse(): BookResponse {
        val responseStr = "{\n" +
                "    \"status\": \"OK\",\n" +
                "    \"code\": 200,\n" +
                "    \"total\": 5,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"title\": \"However, the.\",\n" +
                "            \"author\": \"Bella Stokes\",\n" +
                "            \"genre\": \"Sed\",\n" +
                "            \"description\": \"Hatter. 'You might just as I used--and I don't put my arm round your waist,' the Duchess was VERY ugly; and secondly, because she was quite a new kind of authority over Alice. 'Stand up and beg for.\",\n" +
                "            \"isbn\": \"9780702068195\",\n" +
                "            \"image\": \"http://placeimg.com/480/640/any\",\n" +
                "            \"published\": \"1990-06-09\",\n" +
                "            \"publisher\": \"Dolores Et\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"title\": \"MINE.' The Queen.\",\n" +
                "            \"author\": \"Rafaela Terry\",\n" +
                "            \"genre\": \"Officia\",\n" +
                "            \"description\": \"I'm afraid, but you might do very well without--Maybe it's always pepper that had made out the words: 'Where's the other guinea-pig cheered, and was just saying to herself, 'if one only knew how to.\",\n" +
                "            \"isbn\": \"9780703745798\",\n" +
                "            \"image\": \"http://placeimg.com/480/640/any\",\n" +
                "            \"published\": \"1983-09-12\",\n" +
                "            \"publisher\": \"Ut Voluptate\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"title\": \"Hatter instead!'.\",\n" +
                "            \"author\": \"Sydnie Goodwin\",\n" +
                "            \"genre\": \"Veritatis\",\n" +
                "            \"description\": \"THESE?' said the others. 'We must burn the house of the tale was something like it,' said the Mock Turtle, capering wildly about. 'Change lobsters again!' yelled the Gryphon only answered 'Come on!'.\",\n" +
                "            \"isbn\": \"9792332857988\",\n" +
                "            \"image\": \"http://placeimg.com/480/640/any\",\n" +
                "            \"published\": \"1980-10-11\",\n" +
                "            \"publisher\": \"Consequatur Cum\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 4,\n" +
                "            \"title\": \"March Hare. 'I.\",\n" +
                "            \"author\": \"Greta Bechtelar\",\n" +
                "            \"genre\": \"Consectetur\",\n" +
                "            \"description\": \"Alice. 'Only a thimble,' said Alice hastily; 'but I'm not myself, you see.' 'I don't even know what to beautify is, I can't take LESS,' said the King, looking round the table, but it makes me grow.\",\n" +
                "            \"isbn\": \"9797015727114\",\n" +
                "            \"image\": \"http://placeimg.com/480/640/any\",\n" +
                "            \"published\": \"1998-06-18\",\n" +
                "            \"publisher\": \"Ut Temporibus\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 5,\n" +
                "            \"title\": \"I hate cats and.\",\n" +
                "            \"author\": \"Devan Jones\",\n" +
                "            \"genre\": \"Harum\",\n" +
                "            \"description\": \"I almost wish I had to kneel down on their hands and feet at once, and ran off, thinking while she ran, as well as pigs, and was in managing her flamingo: she succeeded in getting its body tucked.\",\n" +
                "            \"isbn\": \"9794479309146\",\n" +
                "            \"image\": \"http://placeimg.com/480/640/any\",\n" +
                "            \"published\": \"1983-01-11\",\n" +
                "            \"publisher\": \"Labore Amet\"\n" +
                "        }\n" +
                "    ]"

        return Gson().fromJson(responseStr, BookResponse::class.java)
    }
}