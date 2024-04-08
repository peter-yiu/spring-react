"use client";

import Image from "next/image";
import Link from "next/link";
import useScroll from "@/lib/hooks/use-scroll";


export default function NavBar() {

  const scrolled = useScroll(50);
  return (
    <>

      <div  className={`fixed top-0 w-full flex justify-center ${scrolled ? "border-b border-gray-200 bg-white/50 backdrop-blur-xl" : "bg-white/0"} z-30 transition-all`}>
        <div className="mx-5 flex h-16 max-w-screen-xl items-center justify-between w-full">
          <Link href="/" className="flex items-center font-display text-2xl">
            <Image
              src="/logo.png"
              alt="yiu logo"
              width="30"
              height="30"
              className="mr-2 rounded-sm"
            ></Image>
            <p>Yiu App</p>
          </Link>
          <div>

              <button  className="rounded-full border border-black bg-black p-1.5 px-4 text-sm text-white transition-all hover:bg-white hover:text-black">
                Sign In
              </button>

          </div>
        </div>
      </div>
    </>
  );
}
