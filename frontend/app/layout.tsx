import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";
import {Theme} from "@radix-ui/themes";
import Nav from "@/components/layout/nav";
import {Suspense} from "react";
import Footer from "@/components/layout/footer";
import { Toaster } from "sonner";

const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "Spring Boot3 React Full-stack App - Yiu",
  description: "Full-stack App using Next.js/React, Java, Spring Boot 3, Spring Data JPA/Hibernate, TypeScript & MySQL.",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className={inter.className}>

      <Theme >
        <Suspense fallback="...">
          <Nav/>
        </Suspense>
          <Toaster position="top-center" richColors />
        <main className="flex min-h-screen w-full flex-col items-center justify-center py-8">
          {children}
        </main>
        <Footer/>
      </Theme>
      </body>

    </html>
  );
}
