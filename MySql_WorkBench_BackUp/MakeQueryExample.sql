-- 이재하, 조서영
-- Q. 국가별로 가장 많이 본 영화배우의 이름을 국가명 순으로 정렬하여 출력하시오, 출력 칼럼은 다음과 같다. 
-- 국가명, 배우이름(성과 이름을 합쳐서 출력), 해당 배우가 나온 영화를 해당 국가에서 대여한 총 횟수. (횟수가 같은 경우, 모두 출력)
select rankrow.country, rankrow.actor_name, rankrow.rentalCNT from (
    select *, rank() over (
    partition by sub2.country 
    order by sub2.rentalCNT desc
    ) as part from (
        select sub1.country, sub1.actor_name, count(sub1.rental_id) as rentalCNT from (
            select RT.rental_id, concat(AC.first_name, " ", AC.last_name) as actor_name, CO.country
                from country CO join city CT on CO.country_id = CT.country_id
                join address AD on CT.city_id = AD.city_id
                join customer CU on AD.address_id = CU.address_id
                join rental RT on CU.customer_id = RT.customer_id
                join inventory IV on RT.inventory_id = IV.inventory_id
                join film FL on IV.film_id = FL.film_id
                join film_actor FA on FL.film_id = FA.film_id
                join actor AC on FA.actor_id = AC.actor_id
                order by RT.rental_id)
            as sub1
            group by sub1.actor_name, sub1.country
            order by sub1.country, count(sub1.rental_id) desc) 
        as sub2) 
    as rankrow
where rankrow.part =1;
