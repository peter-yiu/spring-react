
import Image from "next/image";


import {Github} from "@/components/shared/icons";
import {nFormatter} from "@/lib/utils";
import {Table, Box, Button, Flex, IconButton, TextField} from "@radix-ui/themes";
import {CirclePlus, Search} from "lucide-react";
import '@radix-ui/themes/styles.css';
import BookList from "@/components/books/book-list";

export default async function Home() {

  const {stargazers_count: stars} = await fetch(
      "https://api.github.com/repos/peter-yiu/spring-react",
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
                href="https://github.com/peter-yiu/spring-react"
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
            Book List
          </h2>


              <BookList/>




        </div>

      </>
  );
}
