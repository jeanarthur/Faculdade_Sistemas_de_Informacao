-- cria tabelas
create table atendimento(
	id int not null primary key,
	dt_atendimento date,
	atendimento boolean,
	resolvido boolean,
	tempo_atendimento int,
	indice_satisfacao int
)

-- insere valores
insert into atendimento values	
	(41, '2022-12-03', true, true, 221, 9),
	(42, '2022-12-05', false, false, 443, 8),
	(43, '2022-12-06', true, true, 213, 9),
	(44, '2022-01-13', true, true, 456, 7),
    (45, '2022-01-15', true, true, 4564, 6),
    (46, '2023-01-03', false, false, 3456, 5),
    (47, '2023-02-12', true, false, 356, 3),
    (48, '2023-02-22', true, true, 456, 5),
    (49, '2023-02-28', true, true, 567, 6),
    (50, '2023-03-01', true, true, 8987, 7),
    (51, '2023-03-02', false, false, 567, 8),
    (52, '2023-03-02', true, true, 345, 9),
    (53, '2023-02-02', true, true, 234, 10),
    (54, '2023-03-02', true, true, 2234, 1),
    (55, '2023-02-13', false, false, 345, 3),
    (56, '2023-02-09', true, false, 456, 2),
    (57, '2022-11-03', true, false, 7568, 5),
    (58, '2022-11-19', true, true, 5675, 7),
    (59, '2022-11-17', true, true, 4564, 8),
    (60, '2022-11-30', true, true, 3455, 9)
    
-- consulta o índice médio de satisfação alcançado pela instituição
select AVG(indice_satisfacao) as 'Índice Médio de Satisfação'
from atendimento
    
-- consulta o tempo total de atendimentos realizados
select SUM(tempo_atendimento) as 'Tempo Total'
from atendimento
    
-- consulta o total de atendimentos realizados
select count(atendimento) as 'Atendimentos realizados'
from atendimento
where atendimento = true

-- consulta o total de atendimentos realizados por ano
select
	extract(year from dt_atendimento) as 'Ano',
	count(atendimento) as 'Atendimentos realizados'
from atendimento
where atendimento = true
group by extract(year from dt_atendimento)

-- consulta o índice médio de satisfação por ano
select
	extract(year from dt_atendimento) as 'Ano',
	AVG(indice_satisfacao) as 'Índice Médio de Satisfação'
from atendimento
where atendimento = true
group by extract(year from dt_atendimento)

-- consulta o tempo médio de atendimento por ano
select
	extract(year from dt_atendimento) as 'Ano',
	AVG(tempo_atendimento) as 'Tempo Médio de Atendimento'
from atendimento
where atendimento = true
group by extract(year from dt_atendimento)
    
-- consulta que indica o total de atendimentos, o tempo médio de atendimento e o índice médio de satisfação por status de atendimento
select
	count(atendimento) as 'Total de Atendimentos',
	AVG(tempo_atendimento) as 'Tempo Médio de Atendimento',
	AVG(indice_satisfacao) as 'Índice Médio de Satisfação'
from atendimento
where atendimento = true
group by resolvido

-- consulta que indica o total de atendimentos, o tempo médio de atendimento e o índice médio de satisfação por status de atendimento (por ano)
select
	extract(year from dt_atendimento) as 'Ano',
	count(atendimento) as 'Total de Atendimentos',
	AVG(tempo_atendimento) as 'Tempo Médio de Atendimento',
	AVG(indice_satisfacao) as 'Índice Médio de Satisfação'
from atendimento
where atendimento = true
group by resolvido, extract(year from dt_atendimento)

-- consulta o maior e o menor índice de satisfação alcançados para os atendimentos em 2023
select
	MAX(indice_satisfacao) as 'Maior índice de satisfação',
	MIN(indice_satisfacao) as 'Menor índice de satisfação'
from atendimento
where dt_atendimento like '%2023%'
    
-- consulta a média de índice de satisfação para atendimentos em que os casos foram resolvidos (T) ou não (F)
select
	resolvido as 'Resolvido',
	AVG(indice_satisfacao) as 'Índice Médio de Satisfação'
from atendimento
group by resolvido