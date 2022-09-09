var Table = {
	field: [
		['','',''],
		['','',''],
		['','','']
	],
	position: [0,0],
	up(){
		if(this.position[0] > 0){
			this.position[0]--;
		}
		this.print();
	},
	down(){
		if(this.position[0] < this.field.length-1){
			this.position[0]++;
		}
		this.print();
	},
	left(){
		if(this.position[1] > 0){
			this.position[1]--;
		}
		this.print();
	},
	right(){
		if(this.position[1] < this.field[this.position[0]].length-1){
			this.position[1]++;
		}
		this.print();
	},
	print(){
		var lineStr = '';
		for(var i = 0; i < this.field.length; i++){
			var line = this.field[i];
			for(var j = 0; j < line.length; j++){
				if(this.position[0] === i && this.position[1] === j){
					lineStr += '| X |';
				}else{
					lineStr += '|   |';
				}
			}
			lineStr += '\n';
		}
		console.log(lineStr);
	}
}

Table.print();