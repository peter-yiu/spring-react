"use client";

import {BuyMeACoffee} from "@/components/shared/icons";
import {useEffect, useState} from "react";
import http from "@/lib/request"
import {Book} from "@/types/book";
import {Box, Button, Flex, IconButton, Table, TextField} from "@radix-ui/themes";
import BookForm from "@/components/books/book-form";
import {CirclePlus, CircleX, RotateCcw, Search} from "lucide-react";
export default function BookList() {

    const [books, setBooks] = useState<Book[]>([]);
    const [newBook, setNewBook] = useState({
        id:0,
        title: '',
        author: '',
        isbn: '',
        genre:'',
        description:''
    });

    const [searchId, setSearchId] = useState('');

    useEffect(() => {
        fetchBooks();
    }, []);

    const fetchBooks =  () => {
        setBooks([]);
        setSearchId("");
           http.get(`/books`) .then(response => {
               console.log("data="+JSON.stringify(response))
                setBooks(response.data.bookList);
            });

    };

    const handleSearch =  () => {
        setBooks([]);
        http.get(`/books/${searchId}`) .then(response => {
            let rearchBook=response.data.book;
            if(rearchBook != null){
                setBooks([rearchBook ]);
            }

        });
    };



    const handleAddBook = (updatedBook:Book) => {

        setBooks([...books, updatedBook]);
    };
    const handleSaveEditedBook = (updatedBook:Book) => {
        const updatedBooks = books.map((book) =>
            book.id === updatedBook.id ? updatedBook : book
        );
        setBooks(updatedBooks); // 更新书籍列表状态
    };

    const handleDelete = (id:number) => {
        const isConfirmed = window.confirm('Are you sure you want to delete this book?');
        if (isConfirmed) {
            http.delete(`/books/${id}`) .then(response => {
                console.log("data="+JSON.stringify(response))
                fetchBooks();
            });
        }
    };

    return (
        <div>
            <div className="drop-shadow-sm text-right">
                <Flex direction="row" gap="5" align="end" justify={"between"}>
                    <Flex direction="row">

                        <TextField.Root size={"2"} radius="small" placeholder="Search the docs…"  defaultValue={searchId}
                                        onChange={(e) => setSearchId(e.target.value)}>

                        </TextField.Root>
                        <IconButton variant="surface">

                            <Search width="18" height="18" onClick={handleSearch} />
                        </IconButton>

                        <IconButton variant="surface" color="green">

                            <RotateCcw  width="18" height="18" onClick={fetchBooks} />
                        </IconButton>
                    </Flex>
                    <Box>
                        <BookForm book={newBook} onSaveEditedBook={handleAddBook} />
                    </Box>


                </Flex>

            </div>
            <Flex direction="column" gap="5">
            <Table.Root variant="surface" size="3">
                <Table.Header>
                    <Table.Row>
                        <Table.ColumnHeaderCell>ID</Table.ColumnHeaderCell>
                        <Table.ColumnHeaderCell>Title</Table.ColumnHeaderCell>
                        <Table.ColumnHeaderCell>Author</Table.ColumnHeaderCell>
                        <Table.ColumnHeaderCell>Isbn</Table.ColumnHeaderCell>
                        <Table.ColumnHeaderCell>Gere</Table.ColumnHeaderCell>
                        <Table.ColumnHeaderCell>Desc</Table.ColumnHeaderCell>
                        <Table.ColumnHeaderCell>Operation</Table.ColumnHeaderCell>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {books.map(book => (

                        <Table.Row key={book.id} >
                            <Table.Cell>{book.id}</Table.Cell>
                            <Table.Cell>{book.title}</Table.Cell>
                            <Table.Cell>{book.author}</Table.Cell>
                            <Table.Cell>{book.isbn}</Table.Cell>
                            <Table.Cell>{book.genre}</Table.Cell>
                            <Table.Cell>{book.description}</Table.Cell>
                            <Table.Cell>
                                <Flex direction="row">
                                <BookForm book={book} onSaveEditedBook={handleSaveEditedBook} />
                                <Button color="red" className="md:rt-r-ml-1" onClick={()=>handleDelete(book.id)}>
                                    <CircleX /> Remove
                                </Button>
                                </Flex>
                            </Table.Cell>

                        </Table.Row>
                    ))}
                </Table.Body>
            </Table.Root>
            </Flex>

        </div>
     );
}