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
  addPost: (post: Omit<Post, 'id'>) => void;
  updateView: (id: number) => void;
  delPost: (id: number) => void;
  updatePost: (id: number, title: string, content: string) => void;
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
    const postId = {...post, id: id};
    setPostList(prev => [postId, ...prev]);
    setId(prev => prev + 1);
  };

  const updateView = (id: number) => {
    setPostList((prev) => {
      return(prev.map((item) => {
        return(
          item.id === id ? {...item, view: item.view + 1} : item
        )
      }))
    })
  }

  const delPost = (id: number) => {
    setPostList((prev) => {
      return(prev.filter((item) => {
        return(item.id !== id)
      }))
    })
  }

  const updatePost = (id: number, title: string, content: string) => {
    setPostList((prev) =>
      prev.map((item) =>
        item.id === id ? { ...item, title: title, content: content } : item
      )
    );
  };

  return (
    <PostContext.Provider value={{ postList, addPost, updateView, delPost, updatePost }}>
      <Stack screenOptions={{ headerShown: false }} />
    </PostContext.Provider>
  );
}
