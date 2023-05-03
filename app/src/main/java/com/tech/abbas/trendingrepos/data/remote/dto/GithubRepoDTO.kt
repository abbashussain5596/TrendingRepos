package com.tech.abbas.trendingrepos.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GithubRepoResponseDTO(
    @Json(name = "total_count") val totalCount: Int,
    @Json(name = "incomplete_results") val incompleteResults: Boolean,
    @Json(name = "items") val items: List<Items>
)

@JsonClass(generateAdapter = true)
data class Owner(
    @Json(name = "login") val login: String,
    @Json(name = "id") val id: Int,
    @Json(name = "node_id") val nodeId: String,
    @Json(name = "avatar_url") val avatarUrl: String,
    @Json(name = "gravatar_id") val gravatarId: String,
    @Json(name = "url") val url: String,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "followers_url") val followersUrl: String,
    @Json(name = "following_url") val followingUrl: String,
    @Json(name = "gists_url") val gistsUrl: String,
    @Json(name = "starred_url") val starredUrl: String,
    @Json(name = "subscriptions_url") val subscriptionsUrl: String,
    @Json(name = "organizations_url") val organizationsUrl: String,
    @Json(name = "repos_url") val reposUrl: String,
    @Json(name = "events_url") val eventsUrl: String,
    @Json(name = "received_events_url") val receivedEventsUrl: String,
    @Json(name = "type") val type: String,
    @Json(name = "site_admin") val siteAdmin: Boolean
)

@JsonClass(generateAdapter = true)
data class License(
    @Json(name = "key") val key: String,
    @Json(name = "name") val name: String,
    @Json(name = "spdx_id") val spdxId: String,
    @Json(name = "url") val url: String,
    @Json(name = "node_id") val nodeId: String
)

@JsonClass(generateAdapter = true)
data class Items(

    @Json(name = "id") val id: Int,
    @Json(name = "node_id") val nodeId: String,
    @Json(name = "name") val name: String,
    @Json(name = "full_name") val fullName: String,
    @Json(name = "private") val private: Boolean,
    @Json(name = "owner") val owner: Owner,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "description") val description: String,
    @Json(name = "fork") val fork: Boolean,
    @Json(name = "url") val url: String,
    @Json(name = "forks_url") val forksUrl: String,
    @Json(name = "keys_url") val keysUrl: String,
    @Json(name = "collaborators_url") val collaboratorsUrl: String,
    @Json(name = "teams_url") val teamsUrl: String,
    @Json(name = "hooks_url") val hooksUrl: String,
    @Json(name = "issue_events_url") val issueEventsUrl: String,
    @Json(name = "events_url") val eventsUrl: String,
    @Json(name = "assignees_url") val assigneesUrl: String,
    @Json(name = "branches_url") val branchesUrl: String,
    @Json(name = "tags_url") val tagsUrl: String,
    @Json(name = "blobs_url") val blobsUrl: String,
    @Json(name = "git_tags_url") val gitTagsUrl: String,
    @Json(name = "git_refs_url") val gitRefsUrl: String,
    @Json(name = "trees_url") val treesUrl: String,
    @Json(name = "statuses_url") val statusesUrl: String,
    @Json(name = "languages_url") val languagesUrl: String,
    @Json(name = "stargazers_url") val stargazersUrl: String,
    @Json(name = "contributors_url") val contributorsUrl: String,
    @Json(name = "subscribers_url") val subscribersUrl: String,
    @Json(name = "subscription_url") val subscriptionUrl: String,
    @Json(name = "commits_url") val commitsUrl: String,
    @Json(name = "git_commits_url") val gitCommitsUrl: String,
    @Json(name = "comments_url") val commentsUrl: String,
    @Json(name = "issue_comment_url") val issueCommentUrl: String,
    @Json(name = "contents_url") val contentsUrl: String,
    @Json(name = "compare_url") val compareUrl: String,
    @Json(name = "merges_url") val mergesUrl: String,
    @Json(name = "archive_url") val archiveUrl: String,
    @Json(name = "downloads_url") val downloadsUrl: String,
    @Json(name = "issues_url") val issuesUrl: String,
    @Json(name = "pulls_url") val pullsUrl: String,
    @Json(name = "milestones_url") val milestonesUrl: String,
    @Json(name = "notifications_url") val notificationsUrl: String,
    @Json(name = "labels_url") val labelsUrl: String,
    @Json(name = "releases_url") val releasesUrl: String,
    @Json(name = "deployments_url") val deploymentsUrl: String,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    @Json(name = "pushed_at") val pushedAt: String,
    @Json(name = "git_url") val gitUrl: String,
    @Json(name = "ssh_url") val sshUrl: String,
    @Json(name = "clone_url") val cloneUrl: String,
    @Json(name = "svn_url") val svnUrl: String,
    @Json(name = "homepage") val homepage: String,
    @Json(name = "size") val size: Int,
    @Json(name = "stargazers_count") val stargazersCount: Int,
    @Json(name = "watchers_count") val watchersCount: Int,
    @Json(name = "language") val language: String,
    @Json(name = "has_issues") val hasIssues: Boolean,
    @Json(name = "has_projects") val hasProjects: Boolean,
    @Json(name = "has_downloads") val hasDownloads: Boolean,
    @Json(name = "has_wiki") val hasWiki: Boolean,
    @Json(name = "has_pages") val hasPages: Boolean,
    @Json(name = "has_discussions") val hasDiscussions: Boolean,
    @Json(name = "forks_count") val forksCount: Int,
    @Json(name = "mirror_url") val mirrorUrl: String,
    @Json(name = "archived") val archived: Boolean,
    @Json(name = "disabled") val disabled: Boolean,
    @Json(name = "open_issues_count") val openIssuesCount: Int,
    @Json(name = "license") val license: License,
    @Json(name = "allow_forking") val allowForking: Boolean,
    @Json(name = "is_template") val isTemplate: Boolean,
    @Json(name = "web_commit_signoff_required") val webCommitSignoffRequired: Boolean,
    @Json(name = "topics") val topics: List<String>,
    @Json(name = "visibility") val visibility: String,
    @Json(name = "forks") val forks: Int,
    @Json(name = "open_issues") val openIssues: Int,
    @Json(name = "watchers") val watchers: Int,
    @Json(name = "default_branch") val defaultBranch: String,
    @Json(name = "score") val score: Int

)