use algorythmn;

-- shfaqja e prezences se punonjesve per nje dite te caktuar

select p.id_punonjes, p.emerpunonjesi, p.mbiemerpunonjesi, a.dita, a.prezenca
from punonjes as p 
inner join paraqitja as a
where p.id_punonjes = a.id_punonjes and a.dita = "2023.05.16" ;

-- query qe afishon prezencen e punonjesve nga dita e pare e muajit deri ne momentin 
-- kur behet run prg ne perqindje

select count(a.prezenca) as ditepune, p.id_punonjes, p.emerpunonjesi, p.mbiemerpunonjesi
from punonjes as p
inner join paraqitja as a
on a.id_punonjes = p.id_punonjes
where  prezenca = 1 and dita between "2023.05.01" and "2023.05.18"
group by p.id_punonjes;





