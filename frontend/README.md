This is a [Next.js](https://nextjs.org/) project bootstrapped with [`create-next-app`](https://github.com/vercel/next.js/tree/canary/packages/create-next-app).

## Getting Started

First, run the development server:
pnpm create next-app

```bash
pnpm dev

pnpm add @radix-ui/themes
pnpm install lucide-react
pnpm install classnames
pnpm install axios
pnpm install sonner
pnpm install @vercel/analytics

```


3. init database

create your database use [local postgres](https://wiki.postgresql.org/wiki/Homebrew) or [vercel-postgres](https://vercel.com/docs/storage/vercel-postgres) or [supabase](https://supabase.com/)

create tables from sql at `data/install.sql`

4. set environmental values

put `.env.local` under `frondend` root dir with values list below

```
WEB_BASE_URI=""
NEXT_PUBLIC_BACKEND_BASE_URI="http://localhost:8080"
```

Set Root Directory to  frontend


Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

You can start editing the page by modifying `app/page.tsx`. The page auto-updates as you edit the file.

This project uses [`next/font`](https://nextjs.org/docs/basic-features/font-optimization) to automatically optimize and load Inter, a custom Google Font.

## Learn More

To learn more about Next.js, take a look at the following resources:

- [Next.js Documentation](https://nextjs.org/docs) - learn about Next.js features and API.
- [Learn Next.js](https://nextjs.org/learn) - an interactive Next.js tutorial.

You can check out [the Next.js GitHub repository](https://github.com/vercel/next.js/) - your feedback and contributions are welcome!

## Deploy on Vercel

The easiest way to deploy your Next.js app is to use the [Vercel Platform](https://vercel.com/new?utm_medium=default-template&filter=next.js&utm_source=create-next-app&utm_campaign=create-next-app-readme) from the creators of Next.js.

Check out our [Next.js deployment documentation](https://nextjs.org/docs/deployment) for more details.
