import Link from "next/link";
import { Input } from "./ui/input";


interface UserListProps {
  users: User[];
}

export default function UserList({ users }: UserListProps) {
  return (
    <div className="space-y-6">
      <div className="space-y-2">
        <h2 className="text-2xl font-bold">List of users</h2>
        <Input type="search" placeholder="Search users..." />
      </div>
      <div className="space-y-2 max-h-[35vh] md:max-h-[80vh] overflow-y-auto px-2">
        {users.map((user) => (
          <Link
            key={user.id}
            href={`/users/${user.id}`}
            className="block text-lg font-semibold text-center bg-gray-200 hover:underline hover:bg-gray-300 rounded-lg py-4"
          >
            {user.name}
          </Link>
        ))}
      </div>
    </div>
  )
}
