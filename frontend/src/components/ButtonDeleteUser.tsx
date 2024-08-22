"use client"

import { useRouter } from "next/navigation"
import { Button } from "./ui/button"

interface ButtonDeleteUserProps {
  id: string
}

export default function ButtonDeleteUser({ id }: ButtonDeleteUserProps) {
  const router = useRouter();

  const deleteUser = async (id: string) => {
    try {
      await fetch(`${process.env.NEXT_PUBLIC_API_URL}/users/${id}`, {
        method: 'DELETE'
      });

      router.push('/');
      router.refresh();
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <Button
      variant="destructive"
      onClick={() => deleteUser(id)}
    >
      Delete
    </Button>
  )
}
