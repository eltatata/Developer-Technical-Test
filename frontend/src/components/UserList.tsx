"use client"

import Link from "next/link";
import { useState } from "react";
import { Input } from "./ui/input";

interface User {
  id: string;
  name: string;
}

interface UserListProps {
  users: User[];
}

export default function UserList({ users }: UserListProps) {
  const [searchTerm, setSearchTerm] = useState("");

  const filteredUsers = users.filter((user) =>
    user.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="space-y-6">
      <div className="space-y-2">
        <h2 className="text-2xl font-bold">List of users</h2>
        <Input
          type="search"
          placeholder="Search users..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
        />
      </div>
      <div className="space-y-2 max-h-[35vh] md:max-h-[80vh] overflow-y-auto px-2">
        {filteredUsers.length > 0 ? (
          filteredUsers.map((user) => (
            <Link
              key={user.id}
              href={`/users/${user.id}`}
              className="block text-lg font-semibold text-center bg-gray-200 hover:underline hover:bg-gray-300 rounded-lg py-4"
            >
              {user.name}
            </Link>
          ))
        ) : (
          <p className="text-center">No users found</p>
        )}
      </div>
    </div>
  );
}
