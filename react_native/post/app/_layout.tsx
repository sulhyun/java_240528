import { Stack } from "expo-router";
import { createContext, useContext, useState } from "react";

type Post = { 
  id: number; 
  title: string; 
  writer: string; 
  content: string;
  view: number; 
  };

// 바구니(Context) 생성
const PostContext = createContext<{
  postList: Post[];
  addPost: (post: Post) => void;
} | null>(null);

// 다른 곳에서 쓰기 편하게 만든 Hook
export const usePosts = () => useContext(PostContext)!;

export default function RootLayout() {
  const [id, setId] = useState(1);
  const [postList, setPostList] = useState<Post[]>([
    { 
      id: 0, 
      title: '공지사항',
      writer: 'Admin',
      content: '공지사항',
      view: 0 
    }
  ]);

  const addPost = (post: Omit<Post, 'id'>) => {
    const postId = { ...post, id: id };
    setPostList(prev => [postId, ...prev]);
    setId(prev => prev + 1);
  };

  return (
    <PostContext.Provider value={{ postList, addPost }}>
      <Stack screenOptions={{ headerShown: false }} />
    </PostContext.Provider>
  );
}
