
import {useEffect, useState} from "react";
import {Book} from "@/types/book";
import http from "@/lib/request";
import {Dialog, Button, Flex, Text, TextField, TextArea} from "@radix-ui/themes";
import {CirclePlus} from "lucide-react";


interface Props {
    book: Book,
    onSaveEditedBook:Function
}

export default function BookForm({ book,onSaveEditedBook }: Props) {
    const [open, setOpen] = useState(false);
    const [editingBook, setEditingBook] = useState(book);
    const saveEditedBook = (book:Book) => {

       if(book.id == 0){
           http.post(`/books`,editingBook) .then(response => {
               setOpen(false)
               onSaveEditedBook(response.data.book); // 调用父组件传递的回调函数
           });
       } else{
           http.put(`/books/${editingBook.id}`,editingBook) .then(response => {
               setOpen(false)
               onSaveEditedBook(response.data.book); // 调用父组件传递的回调函数
           });
       }



    };

    // @ts-ignore
    const handleChange = (e) => {
        const { name, value } = e.target;
        setEditingBook(editingBook => ({
            ...editingBook,
            [name]: value
        }));

    };

    return (
        <div>

            <Dialog.Root open={open} onOpenChange={setOpen}>
                <Dialog.Trigger>

                    { editingBook.id == 0?
                        <Button >
                          <CirclePlus/> Add
                        </Button> : <Button>Edit</Button>}
                </Dialog.Trigger>



                <Dialog.Content maxWidth="650px">
                    <Dialog.Title>Edit Book Detail</Dialog.Title>
                    <Dialog.Description size="2" mb="4">
                        Make changes to your profile.
                    </Dialog.Description>

                    <Flex direction="column" gap="3">
                        <label>
                            <Text as="div" size="2" mb="1" weight="bold">
                                Title
                            </Text>
                            <TextField.Root name="title"  defaultValue={editingBook.title} onChange={(e) => handleChange(e)}
                            />
                        </label>
                        <label>
                            <Text as="div" size="2" mb="1" weight="bold">
                                Author
                            </Text>
                            <TextField.Root name="author"   onChange={(e) => handleChange(e)}
                                defaultValue={editingBook.author}
                            />


                        </label>
                        <label>
                            <Text as="div" size="2" mb="1" weight="bold">
                                Isbn
                            </Text>
                            <TextField.Root name="isbn"  defaultValue={editingBook.isbn} onChange={(e) => handleChange(e)}
                            />
                        </label>
                        <label>
                            <Text as="div" size="2" mb="1" weight="bold">
                                Isbn
                            </Text>
                            <TextField.Root name="genre"  defaultValue={editingBook.genre} onChange={(e) => handleChange(e)}
                            />
                        </label>
                        <label>
                            <Text as="div" size="2" mb="1" weight="bold">
                                Isbn
                            </Text>
                            <TextArea name="description"  defaultValue={editingBook.description} onChange={(e) => handleChange(e)}
                            />
                        </label>

                        <p>Name: {editingBook.title}</p>
                        <p>Email: {editingBook.author}</p>
                    </Flex>

                    <Flex gap="3" mt="4" justify="end">
                        <Dialog.Close>
                            <Button variant="soft" color="gray">
                                Cancel
                            </Button>
                        </Dialog.Close>

                            <Button onClick={() => saveEditedBook(book)} >Save</Button>

                    </Flex>
                </Dialog.Content>
            </Dialog.Root>

        </div>
    );
}