import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import App from './App.jsx';
import List from './test/List.jsx';
import Todo from './todo/Todo.jsx';
import TodoList from './todo/TodoList.jsx';
import ButtonEx1 from './button/ButtonEx1.jsx';
import ButtonEx2 from './button/ButtonEx2.jsx';
import ButtonEx3 from './button/ButtonEx3.jsx';
import ButtonEx4 from './button/ButtonEx4.jsx';
import InputEx1 from './input/InputEx1.jsx';
import InputEx2 from './input/InputEx2.jsx';
import ListEx1 from './list/ListEx1.jsx';
import ListEx2 from './list/ListEx2.jsx';
import ListEx3 from './list/ListEx3.jsx';
import SelectEx from './list/SelectEx.jsx';
import MyTodoList from './todo/MyTodoList.jsx';
import PostEx from './post/PostEx.jsx';

createRoot(document.getElementById('root')).render(
  <StrictMode>
    {/* <App /> */}
    {/* <List /> */}
    {/* <Todo /> */}
    {/* <TodoList /> */}
    {/* <ButtonEx1 /> */}
    {/* <ButtonEx2 /> */}
    {/* <ButtonEx3 /> */}
    {/* <ButtonEx4 /> */}
    {/* <InputEx1 /> */}
    {/* <InputEx2 /> */}
    {/* <ListEx1 /> */}
    {/* <ListEx2 /> */}
    {/* <ListEx3 /> */}
    {/* <SelectEx /> */}
    {/* <MyTodoList /> */}
    <PostEx />
  </StrictMode>
)
