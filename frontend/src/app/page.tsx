import UserForm from "@/components/UserForm";
import UserList from "@/components/UserList";

export default function Home() {
  const users = [
    { id: 1, name: "User 1", email: "user1@gmail.com", address: "123 Street" },
    { id: 2, name: "User 2", email: "user2@gmail.com", address: "123 Street" },
    { id: 3, name: "User 3", email: "user3@gmail.com", address: "123 Street" },
    { id: 4, name: "User 4", email: "user4@gmail.com", address: "123 Street" },
    { id: 5, name: "User 5", email: "user5@gmail.com", address: "123 Street" },
    { id: 6, name: "User 6", email: "user6@gmail.com", address: "456 Avenue" },
    { id: 7, name: "User 7", email: "user7@gmail.com", address: "456 Avenue" },
    { id: 8, name: "User 8", email: "user8@gmail.com", address: "456 Avenue" },
    { id: 9, name: "User 9", email: "user9@gmail.com", address: "456 Avenue" },
    { id: 10, name: "User 10", email: "user10@gmail.com", address: "456 Avenue" },
    { id: 11, name: "User 11", email: "user11@gmail.com", address: "789 Boulevard" },
    { id: 12, name: "User 12", email: "user12@gmail.com", address: "789 Boulevard" },
    { id: 13, name: "User 13", email: "user13@gmail.com", address: "789 Boulevard" },
    { id: 14, name: "User 14", email: "user14@gmail.com", address: "789 Boulevard" },
    { id: 15, name: "User 15", email: "user15@gmail.com", address: "789 Boulevard" },
    { id: 16, name: "User 16", email: "user16@gmail.com", address: "1010 Lane" },
    { id: 17, name: "User 17", email: "user17@gmail.com", address: "1010 Lane" },
    { id: 18, name: "User 18", email: "user18@gmail.com", address: "1010 Lane" },
    { id: 19, name: "User 19", email: "user19@gmail.com", address: "1010 Lane" },
    { id: 20, name: "User 20", email: "user20@gmail.com", address: "1010 Lane" },
  ];


  return (
    <main className="grid grid-cols-1 md:grid-cols-2 w-full max-w-7xl mx-auto gap-20 p-6">
      <UserList users={users} />
      <UserForm />
    </main>
  );
}
