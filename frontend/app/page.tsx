
import Image from "next/image";


import {Github} from "@/components/shared/icons";
import {nFormatter} from "@/lib/utils";
import {Table, Box, Button, Flex, IconButton, TextField} from "@radix-ui/themes";
import {CirclePlus, Search} from "lucide-react";
import '@radix-ui/themes/styles.css';
import BookList from "@/components/books/book-list";

export default async function Home() {

  const {stargazers_count: stars} = await fetch(
      "https://api.github.com/repos/steven-tey/precedent",
      {
        ...(process.env.GITHUB_OAUTH_TOKEN && {
          headers: {
            "Content-Type": "application/json",
          },
        }),
        // data will revalidate every 24 hours
        next: {revalidate: 86400},
      },
  )
      .then((res) => res.json())
      .catch((e) => console.log(e));





  return (
      <>
        <div className="z-10 w-full max-w-screen-xl px-5 xl:px-0">

          <h1 className="text-center font-display text-3xl font-bold tracking-[-0.02em]  [text-wrap:balance] md:text-3xl md:leading-[5rem]">
            Building for your Full-stack App
          </h1>
          <p
              className="mt-6  text-center text-gray-500  [text-wrap:balance] md:text-xl">
            Full-stack App using Next.js/React, Java, Spring Boot 3, Spring Data JPA/Hibernate, TypeScript & MySQL.
          </p>
          <div className="mx-auto mt-6 flex  items-center justify-center space-x-5 ">

            <a
                className="flex max-w-fit items-center justify-center space-x-2 rounded-full border border-gray-300 bg-white px-5 py-2 text-sm text-gray-600 shadow-md transition-colors hover:border-gray-800"
                href="https://github.com/steven-tey/precedent"
                target="_blank"
                rel="noopener noreferrer"
            >
              <Github/>
              <p>
                <span className="hidden sm:inline-block">Star on</span> GitHub{" "}
                <span className="font-semibold">{nFormatter(stars)}</span>
              </p>
            </a>
          </div>
        </div>

        <div className="my-10 grid w-full max-w-screen-xl  grid-cols-1 gap-5 px-5  xl:px-0 ">
          <h2 className="text-left font-display text-2xl text-md-3xl font-bold  drop-shadow-sm ">
            Building for your Next project
          </h2>

          <div className="drop-shadow-sm text-right">
            <Flex direction="row" gap="5" align="end" justify={"between"}>
              <Flex direction="row">

                <TextField.Root size={"2"} radius="small" placeholder="Search the docs…">

                </TextField.Root>
                <IconButton variant="surface">
                  <Search width="18" height="18"/>
                </IconButton>

              </Flex>
              <Box>
                <Button>
                  <CirclePlus/> Add
                </Button>

              </Box>


            </Flex>

          </div>

          <Flex direction="column" gap="5">
            <Table.Root variant="surface" size="3">
              <Table.Header>
                <Table.Row>
                  <Table.ColumnHeaderCell>Full name</Table.ColumnHeaderCell>
                  <Table.ColumnHeaderCell>Email</Table.ColumnHeaderCell>
                  <Table.ColumnHeaderCell>Group</Table.ColumnHeaderCell>
                </Table.Row>
              </Table.Header>

              <Table.Body>
                <Table.Row>
                  <Table.RowHeaderCell>Danilo Sousa</Table.RowHeaderCell>
                  <Table.Cell>danilo@example.com</Table.Cell>
                  <Table.Cell>Developer</Table.Cell>
                </Table.Row>

                <Table.Row>
                  <Table.RowHeaderCell>Zahra Ambessa</Table.RowHeaderCell>
                  <Table.Cell>zahra@example.com</Table.Cell>
                  <Table.Cell>Admin</Table.Cell>
                </Table.Row>

                <Table.Row>
                  <Table.RowHeaderCell>Jasper Eriksson</Table.RowHeaderCell>
                  <Table.Cell>jasper@example.com</Table.Cell>
                  <Table.Cell>Developer</Table.Cell>
                </Table.Row>
              </Table.Body>
            </Table.Root>
          </Flex>

          <BookList/>

        </div>

      </>
  );
}
