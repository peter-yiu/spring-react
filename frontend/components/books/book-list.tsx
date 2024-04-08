"use client";

import {BuyMeACoffee} from "@/components/shared/icons";
import {useEffect, useState} from "react";
import http from "@/lib/request"
import {Book} from "@/types/book";
export default function BookList() {

    const [books, setBooks] = useState<Book[]>([]);
/*    const [newBook, setNewBook] = useState({
        title: '',
        author: '',
        isbn: ''
    });*/

    useEffect(() => {
        fetchBooks();
    }, []);

    const fetchBooks = async () => {

           http.get(`/books`) .then(response => {

               console.log("data="+JSON.stringify(response))
                setBooks(response.data.bookList);
            });

    };



    return (
        <div>
            <h1>Book Management System</h1>
            <ul>
                {books.map(book => (
                    <li key={book.id}>
                        <p>Title: {book.title}</p>
                        <p>Author: {book.author}</p>
                        <p>Genre: {book.genre}</p>
                    </li>
                ))}
            </ul>
        </div>
     );
}