import UserForm from "@/components/UserForm";
import UserList from "@/components/UserList";

const getUsers = async () => {
  const res = await fetch(`${process.env.API_URL}/users`, {
    cache: "no-store",
  });
  const data = await res.json();
  return data;
}

export default async function Home() {
  const users = await getUsers();

  return (
    <main className="grid grid-cols-1 md:grid-cols-2 w-full max-w-7xl mx-auto gap-10 p-6">
      <UserList users={users} />
      <UserForm />
    </main>
  );
}
