package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.DIVIDER_LINE
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.REPO_DESC
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.REPO_LANG
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.REPO_STAR
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.USER_IMAGE
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.USER_NAME
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.USER_REPO
import com.tech.abbas.trendingrepos.presentation.viewModel.RepoListViewModel

@Composable
internal fun RepoSuccessScreen(
    modifier: Modifier,
    data: List<GithubRepo>,
    expandedIds: List<Int>,
    viewModel: RepoListViewModel
) {
    LazyColumn(modifier = modifier) {
        items(data) { repo ->
            ExpandableCard(
                card = repo,
                { viewModel.onRepoItemClicked(repo.id) },
                expanded = expandedIds.contains(repo.id)
            )
        }
    }
}

@Composable
fun ExpandableCard(card: GithubRepo, onCardClick: () -> Unit, expanded: Boolean) {

    Column {
        AnimatedVisibility(visible = !expanded) {
            RepoCollapsedView(repo = card,
                Modifier.clickable {
                    onCardClick()
                })
        }
        RepoExpandedView(repo = card, visible = expanded, initialVisibility = expanded)
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RepoExpandedView(repo: GithubRepo, visible: Boolean, initialVisibility: Boolean) {

    val enterTransition = remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(450)
        ) + fadeIn(
            initialAlpha = 0.3f,
            animationSpec = tween(450)
        )
    }
    val exitTransition = remember {
        shrinkVertically(
            // Expand from the top.
            shrinkTowards = Alignment.Top,
            animationSpec = tween(450)
        ) + fadeOut(
            // Fade in with the initial alpha of 0.3f.
            animationSpec = tween(450)
        )
    }

    AnimatedVisibility(
        visible = visible,
        enter = enterTransition,
        exit = exitTransition
    ) {
        ExpandedView(repo)

    }

}

@Composable
fun ExpandedView(repo: GithubRepo) {

    Column(Modifier.padding(top = 8.dp)) {
        RepoTwinUI(repo)
        Text(
            text = repo.description,
            fontSize = 14.sp,
            modifier = Modifier
                .testTag(REPO_DESC)
                .padding(start = 82.dp)
        )
        Row (Modifier.padding(start = 72.dp)){
            DrawableLeftText(
                modifier = Modifier.semantics { testTag = REPO_LANG },
                imageVector = Icons.Filled.Info,
                text = repo.language
            )
            DrawableLeftText(
                modifier = Modifier.semantics { testTag = REPO_STAR },
                imageVector = Icons.Filled.Star,
                text = repo.starsCount.toString()
            )
        }
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier
                .testTag(DIVIDER_LINE)
                .padding(start = 15.dp)
        )
    }

}

@Composable
fun DrawableLeftText(modifier: Modifier, imageVector: ImageVector, text: String) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(12.dp, 12.dp, 0.dp, 16.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(
            imageVector,
            contentDescription = "icon",
        )
        Text(
            text = text,
            textAlign = TextAlign.Left,
            fontSize = 14.sp,
        )
    }
}

@Composable
fun RepoCollapsedView(
    repo: GithubRepo,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.padding(top = 8.dp)
    ) {
        RepoTwinUI(repo)
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier
                .testTag(DIVIDER_LINE)
                .padding(start = 15.dp, top = 6.dp)
        )

    }

}

@Composable
fun RepoTwinUI(repo: GithubRepo) {
    Row(Modifier.padding(18.dp, 2.dp)) {

        AsyncImage(
            model = repo.avatarUrl,
            contentDescription = "avatar",
            modifier = Modifier
                .padding(end = 10.dp)
                .testTag(USER_IMAGE)
                .size(44.dp)
                .clip(CircleShape)
                .border(1.dp, Color.LightGray, CircleShape)
        )

        Column() {
            Text(
                text = repo.name,
                fontSize = 14.sp,
                modifier = Modifier
                    .testTag(USER_NAME)
                    .padding(start = 8.dp, bottom = 4.dp)
            )
            Text(
                text = repo.repoName,
                fontSize = 16.sp,
                modifier = Modifier
                    .testTag(USER_REPO)
                    .padding(start = 8.dp)
            )

        }

    }

}

object RepoSuccessScreen {
    const val USER_IMAGE = "userImage"
    const val USER_NAME = "userName"
    const val USER_REPO = "userRepo"
    const val REPO_DESC = "repoDesc"
    const val REPO_STAR = "repoStar"
    const val REPO_LANG = "repoLang"
    const val DIVIDER_LINE = "divider"

}