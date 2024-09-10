import { useState } from "react";

function PaginationBox({maxPage}){

	let [page, setPage] = useState(1);

	function prevPage(){
		if(page > 1){
			setPage(page - 1);
		}
		else{
			setPage(maxPage);
		}
	}

	function nextPage(){
		if(page < maxPage){
			setPage(page + 1);
		}
		else{
			setPage(1);
		}
	}

	return(
		<div>
			<button onClick={prevPage}>&lt;</button>
			<span>
				<span>{page}</span>
				<span>/</span>
				<span>{maxPage}</span>
			</span>
			<button onClick={nextPage}>&gt;</button>
		</div>
	);
}

export default PaginationBox;