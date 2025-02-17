SELECT name, datetime from (select i.name as name, i.datetime as datetime from animal_ins i left outer join animal_outs o on i.animal_id = o.animal_id
                            where o.animal_id is null
                            order by 2 asc
                           )
where rownum <= 3
order by 2;