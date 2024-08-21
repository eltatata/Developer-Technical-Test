import dynamic from 'next/dynamic'
import UserForm from '@/components/UserForm'
const Map = dynamic(() => import('@/components/Map'), { ssr: false })

const getSingleUser = async (id: string) => {
  const res = await fetch(`${process.env.API_URL}/users/${id}`)
  const data = await res.json()
  return data
}

interface SingleUserPageProps {
  params: {
    id: string
  }
}

export default async function SingleUserPage({ params }: SingleUserPageProps) {
  const user = await getSingleUser(params.id)

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 w-full max-w-7xl mx-auto gap-20 p-6">
      <UserForm
        id={params.id}
        user={user}
      />
      <Map
        position={[user.latitude, user.longitude]}
      />
    </div>
  )
}
