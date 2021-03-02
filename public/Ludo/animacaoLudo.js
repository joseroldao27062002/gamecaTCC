var yellow = "#ffff00";
            var red = "#ff0000";
            var green = "#00ff00";
            var white = "#ffffff";
            var blue = "#0000CD";

			/*Inicio do vetor de peças*/
            var trilhas = [
                /*Home amarela*/
                {i: 0, j: 9, color: white},
                {i: 0, j: 14, color: white},
                {i: 5, j: 9, color: white},
                {i: 5, j: 14, color: white},
                {i: 1, j: 10, color: white},
                {i: 1, j: 13, color: white},
                {i: 2, j: 11, color: white},
                {i: 3, j: 12, color: white},
                {i: 4, j: 10, color: white},
                {i: 4, j: 13, color: white},
                /*Trilha amarela*/
                {i: 0, j: 6, color: yellow},
                {i: 0, j: 7, color: yellow},
                {i: 1, j: 6, color: white},
                {i: 2, j: 6, color: white},
                {i: 0, j: 8, color: yellow},
                {i: 1, j: 8, color: white},
                {i: 1, j: 8, color: white},
                {i: 2, j: 8, color: white},
                {i: 3, j: 8, color: white},
                {i: 4, j: 8, color: white},
                {i: 3, j: 6, color: white},
                {i: 4, j: 6, color: white},
                {i: 1, j: 7, color: yellow},
                {i: 2, j: 7, color: yellow},
                {i: 3, j: 7, color: yellow},
                {i: 4, j: 7, color: yellow},
                {i: 5, j: 7, color: yellow},
                {i: 5, j: 6, color: yellow},
                {i: 5, j: 8, color: yellow},

                /*Home azul*/
                {i: 9, j: 9, color: white},
                {i: 9, j: 14, color: white},
                {i: 14, j: 9, color: white},
                {i: 14, j: 14, color: white},
                {i: 10, j: 10, color: white},
                {i: 10, j: 13, color: white},
                {i: 13, j: 10, color: white},
                {i: 13, j: 13, color: white},
                {i: 12, j: 11, color: white},
                {i: 11, j: 12, color: white},
                /*Trilha azul*/
                {i: 6, j: 9, color: blue},
                {i: 6, j: 10, color: white},
                {i: 6, j: 11, color: white},
                {i: 6, j: 12, color: white},
                {i: 6, j: 13, color: white},
                {i: 6, j: 14, color: blue},
                {i: 7, j: 10, color: blue},
                {i: 7, j: 11, color: blue},
                {i: 7, j: 12, color: blue},
                {i: 7, j: 13, color: blue},
                {i: 7, j: 14, color: blue},
                {i: 7, j: 9, color: blue},
                {i: 8, j: 9, color: blue},
                {i: 8, j: 10, color: white},
                {i: 8, j: 11, color: white},
                {i: 8, j: 12, color: white},
                {i: 8, j: 13, color: white},
                {i: 8, j: 14, color: blue},

                /*Home vermelha*/
                {i: 9, j: 0, color: white},
                {i: 9, j: 5, color: white},
                {i: 14, j: 0, color: white},
                {i: 14, j: 5, color: white},
                {i: 10, j: 1, color: white},
                {i: 10, j: 4, color: white},
                {i: 13, j: 1, color: white},
                {i: 13, j: 4, color: white},
                {i: 11, j: 3, color: white},
                {i: 12, j: 2, color: white},
                /*Trilha vermelha*/
                {i: 9, j: 6, color: red},
                {i: 9, j: 7, color: red},
                {i: 10, j: 6, color: white},
                {i: 11, j: 6, color: white},
                {i: 9, j: 8, color: red},
                {i: 10, j: 8, color: white},
                {i: 11, j: 8, color: white},
                {i: 12, j: 8, color: white},
                {i: 13, j: 8, color: white},
                {i: 12, j: 6, color: white},
                {i: 13, j: 6, color: white},
                {i: 4, j: 8, color: white},
                {i: 3, j: 6, color: white},
                {i: 4, j: 6, color: white},
                {i: 9, j: 7, color: red},
                {i: 10, j: 7, color: red},
                {i: 11, j: 7, color: red},
                {i: 12, j: 7, color: red},
                {i: 13, j: 7, color: red},
                {i: 14, j: 6, color: red},
                {i: 14, j: 8, color: red},
                {i: 14, j: 7, color: red},
                
                /*Home verde*/
                {i: 0, j: 0, color: white},
                {i: 0, j: 5, color: white},
                {i: 5, j: 0, color: white},
                {i: 5, j: 5, color: white},
                {i: 1, j: 1, color: white},
                {i: 1, j: 4, color: white},
                {i: 4, j: 4, color: white},
                {i: 4, j: 1, color: white},
                {i: 2, j: 2, color: white},
                {i: 3, j: 3, color: white},
                /*Trilha verde*/
                {i: 6, j: 0, color: green},
                {i: 6, j: 1, color: white},
                {i: 6, j: 2, color: white},
                {i: 6, j: 3, color: white},
                {i: 6, j: 4, color: white},
                {i: 6, j: 5, color: green},
                {i: 7, j: 0, color: green},
                {i: 7, j: 1, color: green},
                {i: 7, j: 2, color: green},
                {i: 7, j: 3, color: green},
                {i: 7, j: 4, color: green},
                {i: 7, j: 5, color: green},
                {i: 8, j: 0, color: green},
                {i: 8, j: 1, color: white},
                {i: 8, j: 2, color: white},
                {i: 8, j: 3, color: white},
                {i: 8, j: 4, color: white},
                {i: 8, j: 5, color: green},
                
            ];
	
			
            var pecas = [
                /*Peças azuis*/
                {i: 9, j: 9, color: blue, id: 0, pos: -1},
                {i: 9, j: 14, color: blue, id: -1, pos: -1},
                {i: 14, j: 9, color: blue, id: -1, pos: -1},
                {i: 14, j: 14, color: blue, id: -1, pos: -1},
                {i: 10, j: 10, color: blue, id: -1, pos: -1},
                {i: 10, j: 13, color: blue, id: -1, pos: -1},
                {i: 13, j: 10, color: blue, id: -1, pos: -1},
                {i: 13, j: 13, color: blue, id: -1, pos: -1},
                {i: 12, j: 11, color: blue, id: -1, pos: -1},
                {i: 11, j: 12, color: blue, id: -1, pos: -1},

                /*peças amarelas*/
                {i: 0, j: 9, color: yellow, id: -1, pos: -1},
                {i: 0, j: 14, color: yellow, id: -1, pos: -1},
                {i: 5, j: 9, color: yellow, id: -1, pos: -1},
                {i: 5, j: 14, color: yellow, id: -1, pos: -1},
                {i: 1, j: 10, color: yellow, id: -1, pos: -1},
                {i: 1, j: 13, color: yellow, id: -1, pos: -1},
                {i: 2, j: 11, color: yellow, id: -1, pos: -1},
                {i: 3, j: 12, color: yellow, id: -1, pos: -1},
                {i: 4, j: 10, color: yellow, id: -1, pos: -1},
                {i: 4, j: 13, color: yellow, id: -1, pos: -1},

                /*peças verdes*/
                {i: 0, j: 0, color: green, id: -1, pos: -1},
                {i: 0, j: 5, color: green, id: -1, pos: -1},
                {i: 5, j: 0, color: green, id: -1, pos: -1},
                {i: 5, j: 5, color: green, id: -1, pos: -1},
                {i: 1, j: 1, color: green, id: -1, pos: -1},
                {i: 1, j: 4, color: green, id: -1, pos: -1},
                {i: 4, j: 4, color: green, id: -1, pos: -1},
                {i: 4, j: 1, color: green, id: -1, pos: -1},
                {i: 2, j: 2, color: green, id: -1, pos: -1},
                {i: 3, j: 3, color: green, id: -1, pos: -1},

                /*
                {i: 9, j: 0, color: white},
                {i: 9, j: 5, color: white},
                {i: 14, j: 0, color: white},
                {i: 14, j: 5, color: white},
                {i: 10, j: 1, color: white},
                {i: 10, j: 4, color: white},
                {i: 13, j: 1, color: white},
                {i: 13, j: 4, color: white},
                {i: 11, j: 3, color: white},
                {i: 12, j: 2, color: white},
                */
                /*peças vermelhas*/
                {i: 9, j: 0, color: red, id: -1, pos: -1},
                {i: 9, j: 5, color: red, id: -1, pos: -1},
                {i: 14, j: 0, color: red, id: -1, pos: -1},
                {i: 14, j: 5, color: red, id: -1, pos: -1},
                {i: 10, j: 1, color: red, id: -1, pos: -1},
                {i: 10, j: 4, color: red, id: -1, pos: -1},
                {i: 13, j: 1, color: red, id: -1, pos: -1},
                {i: 13, j: 4, color: red, id: -1, pos: -1},
                {i: 11, j: 3, color: red, id: -1, pos: -1},
                {i: 12, j: 2, color: red, id: -1, pos: -1},
            ];
            /*Fim do vetor de peças*/
            
          
            var caminho_amarelo = [

                {i: 1, j: 8},
                {i: 0, j: 8},
                {i: 0, j: 7},
                {i: 0, j: 6},
                {i: 1, j: 6},
                {i: 2, j: 6},
                {i: 3, j: 6},
                {i: 4, j: 6},
                {i: 5, j: 6},

                {i: 6, j: 5},
                {i: 6, j: 4},
                {i: 6, j: 3},
                {i: 6, j: 2},
                {i: 6, j: 1},
                {i: 6, j: 0},
                {i: 7, j: 0},
                {i: 8, j: 0},

                {i: 8, j: 1},
                {i: 8, j: 2},
                {i: 8, j: 3},
                {i: 8, j: 4},
                {i: 8, j: 5},
                {i: 9, j: 6},

                {i: 10, j: 6},
                {i: 11, j: 6},
                {i: 12, j: 6},
                {i: 13, j: 6},
                {i: 14, j: 6},
                {i: 14, j: 7},
                {i: 14, j: 8},

                {i: 13, j: 8},
                {i: 12, j: 8},
                {i: 11, j: 8},
                {i: 10, j: 8},
                {i: 9, j: 8},
                {i: 8, j: 9},

                {i: 8, j: 10},
                {i: 8, j: 11},
                {i: 8, j: 12},
                {i: 8, j: 13},
                {i: 8, j: 14},
                {i: 7, j: 14},
                {i: 6, j: 14},

                {i: 6, j: 13},
                {i: 6, j: 12},
                {i: 6, j: 11},
                {i: 6, j: 10},
                {i: 6, j: 9},
                {i: 5, j: 8},

                {i: 4, j: 8},
                {i: 3, j: 8},
                {i: 2, j: 8},
                {i: 1, j: 8},
                {i: 0, j: 8},

                {i: 0, j: 7},
                {i: 1, j: 7},
                {i: 2, j: 7},
                {i: 3, j: 7},
                {i: 4, j: 7},
                {i: 5, j: 7},
                {i: 6, j: 7}
                
            ];

            var caminho_verde = [
                {i: 6, j: 1},
                {i: 6, j: 0},
                {i: 7, j: 0},
                {i: 8, j: 0},

                {i: 8, j: 1},
                {i: 8, j: 2},
                {i: 8, j: 3},
                {i: 8, j: 4},
                {i: 8, j: 5},
                {i: 9, j: 6},

                {i: 10, j: 6},
                {i: 11, j: 6},
                {i: 12, j: 6},
                {i: 13, j: 6},
                {i: 14, j: 6},
                {i: 14, j: 7},
                {i: 14, j: 8},

                {i: 13, j: 8},
                {i: 12, j: 8},
                {i: 11, j: 8},
                {i: 10, j: 8},
                {i: 9, j: 8},
                {i: 8, j: 9},

                {i: 8, j: 10},
                {i: 8, j: 11},
                {i: 8, j: 12},
                {i: 8, j: 13},
                {i: 8, j: 14},
                {i: 7, j: 14},
                {i: 6, j: 14},

                {i: 6, j: 13},
                {i: 6, j: 12},
                {i: 6, j: 11},
                {i: 6, j: 10},
                {i: 6, j: 9},
                {i: 5, j: 8},

                {i: 4, j: 8},
                {i: 3, j: 8},
                {i: 2, j: 8},
                {i: 1, j: 8},
                {i: 0, j: 8},
                {i: 0, j: 7},
                {i: 0, j: 6},

                {i: 1, j: 6},
                {i: 2, j: 6},
                {i: 3, j: 6},
                {i: 4, j: 6},
                {i: 5, j: 6},
                {i: 6, j: 5},

                {i: 6, j: 4},
                {i: 6, j: 3},
                {i: 6, j: 2},
                {i: 6, j: 1},
                {i: 6, j: 0},
                {i: 7, j: 0},

                {i: 7, j: 1},
                {i: 7, j: 2},
                {i: 7, j: 3},
                {i: 7, j: 4},
                {i: 7, j: 5},
                
            ];

            var caminho_vermelho = [
                {i: 13, j: 6},
                {i: 14, j: 6},
                {i: 14, j: 7},
                {i: 14, j: 8},

                {i: 13, j: 8},
                {i: 12, j: 8},
                {i: 11, j: 8},
                {i: 10, j: 8},
                {i: 9, j: 8},
                {i: 8, j: 9},

                {i: 8, j: 10},
                {i: 8, j: 11},
                {i: 8, j: 12},
                {i: 8, j: 13},
                {i: 8, j: 14},
                {i: 7, j: 14},
                {i: 6, j: 14},

                {i: 6, j: 13},
                {i: 6, j: 12},
                {i: 6, j: 11},
                {i: 6, j: 10},
                {i: 6, j: 9},
                {i: 5, j: 8},

                {i: 4, j: 8},
                {i: 3, j: 8},
                {i: 2, j: 8},
                {i: 1, j: 8},
                {i: 0, j: 8},
                {i: 0, j: 7},
                {i: 0, j: 6},

                {i: 1, j: 6},
                {i: 2, j: 6},
                {i: 3, j: 6},
                {i: 4, j: 6},
                {i: 5, j: 6},
                {i: 6, j: 5},

                {i: 6, j: 4},
                {i: 6, j: 3},
                {i: 6, j: 2},
                {i: 6, j: 1},
                {i: 6, j: 0},
                {i: 7, j: 0},
                {i: 8, j: 0},

                {i: 8, j: 1},
                {i: 8, j: 2},
                {i: 8, j: 3},
                {i: 8, j: 4},
                {i: 8, j: 5},
                {i: 9, j: 6},

                {i: 10, j: 6},
                {i: 11, j: 6},
                {i: 12, j: 6},
                {i: 13, j: 6},
                {i: 14, j: 6},
                {i: 14, j: 7},

                {i: 13, j: 7},
                {i: 12, j: 7},
                {i: 11, j: 7},
                {i: 10, j: 7},
                {i: 9, j: 7},
                {i: 8, j: 7},
            ];

            var caminho_azul = [
                {i: 8, j: 13},
                {i: 8, j: 14},
                {i: 7, j: 14},
                {i: 6, j: 14},

                {i: 6, j: 13},
                {i: 6, j: 12},
                {i: 6, j: 11},
                {i: 6, j: 10},
                {i: 6, j: 9},
                {i: 5, j: 8},

                {i: 4, j: 8},
                {i: 3, j: 8},
                {i: 2, j: 8},
                {i: 1, j: 8},
                {i: 0, j: 8},
                {i: 0, j: 7},
                {i: 0, j: 6},

                 {i: 1, j: 6},
                {i: 2, j: 6},
                {i: 3, j: 6},
                {i: 4, j: 6},
                {i: 5, j: 6},
                {i: 6, j: 5},

                {i: 6, j: 4},
                {i: 6, j: 3},
                {i: 6, j: 2},
                {i: 6, j: 1},
                {i: 6, j: 0},
                {i: 7, j: 0},
                {i: 8, j: 0},

                {i: 8, j: 1},
                {i: 8, j: 2},
                {i: 8, j: 3},
                {i: 8, j: 4},
                {i: 8, j: 5},
                {i: 9, j: 6},

                {i: 10, j: 6},
                {i: 11, j: 6},
                {i: 12, j: 6},
                {i: 13, j: 6},
                {i: 14, j: 6},
                {i: 14, j: 7},
                {i: 14, j: 8},

                {i: 13, j: 8},
                {i: 12, j: 8},
                {i: 11, j: 8},
                {i: 10, j: 8},
                {i: 9, j: 8},
                {i: 8, j: 9},

                {i: 8, j: 10},
                {i: 8, j: 11},
                {i: 8, j: 12},
                {i: 8, j: 13},
                {i: 8, j: 14},
                {i: 7, j: 14},

                {i: 7, j: 13},
                {i: 7, j: 12},
                {i: 7, j: 11},
                {i: 7, j: 10},
                {i: 7, j: 9},
                {i: 7, j: 8},
                
            ];

			function executarAjax() {
				var ajaxRequest = new XMLHttpRequest();
				var idSala = document.getElementById("idSala").value;
				ajaxRequest.onreadystatechange = function() {
					if (ajaxRequest.readyState == 4 && ajaxRequest.status == 200) {
						var dados = JSON.parse(ajaxRequest.responseText);
						
						for (var c = 0; c < dados.length; c++) {
							if (pecas[c].id == -1) {
								pecas[c].id = c;
								/*
								alert(pecas[c].id);
								alert(dados[c].pontuacaoPorCa);
								alert(pecas.pos);	
								alert("olá");
								*/
							}
						}
						
						for (var contad = 0; contad < dados.length; contad++) {
							atualizarPeca(contad, dados[contad].pontuacaoPorCA);
							//alert("achhou");
							//alert(pecas[contad].pos);
						}									
					}
				}
				ajaxRequest.open('GET', 'http://localhost:9000/centrosaprendizagem/serializardados?idSala=' + idSala, true);
				ajaxRequest.send();	 	
			}	
			
            function desenharTabuleiro() {
                var canvas = document.getElementById("tabuleiro");
                var ctx = canvas.getContext("2d");

                var width = canvas.width;
                var height = canvas.height;
                var step = width / 15;
                var raio = step / 2 - step * 0.1;

                ctx.clearRect(0, 0, width, height);

                for (var i = 0; i < trilhas.length; ++i) {
                    var ii = trilhas[i].i * step;
                    var jj = trilhas[i].j * step;
                    ctx.beginPath();
                    ctx.fillStyle = trilhas[i].color;
                    ctx.fillRect(jj, ii, step, step);

                    ctx.beginPath();
                    ctx.fillStyle = "#FF0000";
                    ctx.strokeRect(jj, ii, step, step);
                }

                // pinta as peças
                for (var i = 0; i < pecas.length; ++i) {
                    if (pecas[i].pos == -1) { //
                        ctx.beginPath();
                        ctx.fillStyle = pecas[i].color;
                        var ii = pecas[i].i * step + step / 2;
                        var jj = pecas[i].j * step + step / 2;

                        ctx.arc(jj, ii, raio, 0, 2 * Math.PI);
                        ctx.fill();
                    } else {
                        ctx.beginPath();
                        ctx.fillStyle = pecas[i].color;

                        if (pecas[i].color == yellow) {
                            var ii = caminho_amarelo[pecas[i].pos].i * step + step / 2;
                            var jj = caminho_amarelo[pecas[i].pos].j * step + step / 2;
                        } else if (pecas[i].color == green) {
                            var ii = caminho_verde[pecas[i].pos].i * step + step / 2;
                            var jj = caminho_verde[pecas[i].pos].j * step + step / 2;
                        } else if (pecas[i].color == red) {
                            var ii = caminho_vermelho[pecas[i].pos].i * step + step / 2;
                            var jj = caminho_vermelho[pecas[i].pos].j * step + step / 2;
                        } else if (pecas[i].color == blue) {
                            var ii = caminho_azul[pecas[i].pos].i * step + step / 2;
                            var jj = caminho_azul[pecas[i].pos].j * step + step / 2;
                        }

                        ctx.arc(jj, ii, raio, 0, 2 * Math.PI);
                        ctx.fill();
                    }
                }
            }

            function atualizarPeca(id, pontos) {
            	//alert(id);
            	//alert(pontos);
                for (var i = 0; i < pecas.length; ++i) {
                    if (pecas[i].id == id) { console.log("ACHOU");
                        pecas[i].pos = pecas[i].pos + pontos;
                    }
                }
                desenharTabuleiro();
            }

            desenharTabuleiro();
            window.onload = (event) => {
            	executarAjax();
            }
