package ru.rti

import org.hibernate.search.jpa.FullTextQuery
import org.springframework.stereotype.Repository
import javax.transaction.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Repository
@Transactional
internal class UserSearch(@PersistenceContext val entityManager: EntityManager) {

    fun searchUsers(text: String): List<User> {
        // get the full text entity manager
        val fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager)

        // create the query using Hibernate Search query DSL
        val queryBuilder = fullTextEntityManager.searchFactory
                .buildQueryBuilder().forEntity(User::class.java).get()

        // a very basic query by keywords
        val query = queryBuilder
                .keyword()
                .onFields("name")
                .matching(text)
                .createQuery()

        // wrap Lucene query in an Hibernate Query object
        val jpaQuery: FullTextQuery = fullTextEntityManager.createFullTextQuery(query, User::class.java)

        // execute search and return results (sorted by relevance as default)

        return jpaQuery.resultList.map { result -> result as User }.toList()
    }
}