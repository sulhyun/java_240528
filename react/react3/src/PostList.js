import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function PostList(){

	let [list, setList] = useState([]);
	let [pm, setPm] = useState({});
	const {co_num} = useParams();

	useEffect(() => {
		fetch('/spring/react/post/list/'+co_num)
			.then((res) => res.json())
			.then(res=>{
				// map은 A => B
				var tmp = res.list.map(item=>{
					// 정수로 된 날짜 정보를 Date 객체로 변환하기 위해서
					var date = (new Date(item.po_date)).toLocaleDateString();
					item = {...item, date};
					return item;
				})
				// setList(res.list);
				setList(tmp);
				setPm(res.pm);
			})
	}, []);

	return(
		<div>
			<table border={1}>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					{
						list.map((item)=>{
							return(
								<tr>
									<th>{item.po_num}</th>
									<th>{item.po_title}</th>
									<th>{item.po_me_id}</th>
									<th>{item.po_date}</th>
									<th>{item.po_view}</th>
								</tr>
							)
						})
					}
				</tbody>
			</table>
		</div>
	)
}

export default PostList;