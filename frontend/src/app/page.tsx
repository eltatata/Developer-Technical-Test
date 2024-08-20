import UserForm from "@/components/UserForm";

export default function Home() {
  return (
    <main className="grid grid-cols-1 md:grid-cols-2 w-full max-w-7xl mx-auto gap-20 p-6">
      <UserForm />
    </main>
  );
}
