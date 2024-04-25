package com.example.myproject.screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myproject.DetailsPageActivity

import com.example.myproject.R
import com.example.myproject.UserProfileActivity
import com.example.myproject.components.AppToolbar
import com.example.myproject.components.NavigationDrawerBody
import com.example.myproject.components.NavigationDrawerHeader

import com.example.myproject.data.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere","inside_NavigationItemClicked")
                    Log.d("ComingHere","${it.itemId} ${it.title}")
                })
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 360.dp)
                        .requiredHeight(height = 640.dp)
                        .background(color = Color.White)
                ) {


                    Text(
                        text = "All       Fruits ",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 11.dp,
                                y = 92.dp
                            )
                            .requiredWidth(width = 359.dp)
                            .requiredHeight(height = 41.dp)
                    )
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 0.dp,
                                y = 92.dp
                            )
                            .requiredWidth(width = 51.dp)
                            .requiredHeight(height = 28.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color(0xFFFF5722).copy(alpha = 0.51f))
                    )
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 21.dp,
                                y = 134.dp
                            )
                            .requiredWidth(width = 26.dp)
                            .requiredHeight(height = 38.dp)
                            .background(color = Color(0xff110506).copy(alpha = 0.82f))
                    )
                    Text(
                        text = "Fresh Fruits......",
                        color = Color.Black,
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 57.dp,
                                y = 143.dp
                            )
                            .requiredWidth(width = 175.dp)
                            .requiredHeight(height = 29.dp)
                    )
                    val localContext = LocalContext.current
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 13.dp,
                                y = 181.dp
                            )
                            .requiredWidth(width = 146.dp)
                            .requiredHeight(height = 209.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = "",
                            modifier = Modifier
                                .requiredWidth(width = 157.dp)
                                .requiredHeight(height = 150.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                        )
                        val localContext = LocalContext.current


                    }
                    Text(
                        text = "Custard Apple",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 72.dp, y = 539.dp)
                    )
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 220.dp, y = 172.dp)
                            .requiredWidth(width = 146.dp)
                            .requiredHeight(height = 211.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.grapes),
                            contentDescription = "",
                            modifier = Modifier
                                .requiredWidth(width = 157.dp)
                                .requiredHeight(height = 156.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                        )

                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 219.dp,
                                y = 417.dp
                            )
                            .requiredWidth(width = 147.dp)
                            .requiredHeight(height = 150.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.custardapple),
                            contentDescription = "",
                            modifier = Modifier
                                .requiredWidth(width = 158.dp)
                                .requiredHeight(height = 140.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 21.dp,
                                y = 410.dp
                            )
                            .requiredWidth(width = 150.dp)
                            .requiredHeight(height = 100.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.grapes),
                            contentDescription = "",
                            modifier = Modifier
                                .requiredWidth(width = 107.dp)
                                .requiredHeight(height = 106.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                        )
                    }

                    Text(
                        text = "Hi! Rajinikanth",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .clickable {
                                localContext.startActivity(
                                    Intent(
                                        localContext,
                                        UserProfileActivity::class.java
                                    )
                                )
                            }
                            .offset(
                                x = 58.dp,
                                y = 40.dp
                            ))
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 1.dp, y = 26.dp)
                            .requiredSize(size = 42.dp)
                            .clickable {
                                localContext.startActivity(
                                    Intent(
                                        localContext,
                                        UserProfileActivity::class.java
                                    )
                                )
                            }
                            .clip(shape = CircleShape)
                            .border(
                                border = BorderStroke(0.10000000149011612.dp, Color(0xffbdbdbd)),
                                shape = CircleShape
                            ))

                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 0.dp,
                                y = 92.dp
                            )
                            .requiredWidth(width = 51.dp)
                            .requiredHeight(height = 28.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color(0xFFFF5722).copy(alpha = 0.51f))
                    )
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 21.dp,
                                y = 134.dp
                            )
                            .requiredWidth(width = 26.dp)
                            .requiredHeight(height = 8.dp)
                            .background(color = Color(0xFFFF5722).copy(alpha = 0.82f))
                    )

                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 13.dp,
                                y = 181.dp
                            )
                            .requiredWidth(width = 146.dp)
                            .requiredHeight(height = 209.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                    ) {

                        Text(
                            text = "Mangoes",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 60.dp,
                                    y = 161.dp
                                )
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 220.dp,
                                y = 172.dp
                            )
                            .requiredWidth(width = 146.dp)
                            .requiredHeight(height = 211.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                    ) {
                        Text(
                            text = "Apples",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 23.dp,
                                    y = 168.dp
                                )
                                .requiredWidth(width = 95.dp)
                                .requiredHeight(height = 28.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.mangoes),
                        contentDescription = "",

                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 21.dp,
                                y = 176.dp
                            )
                            .requiredWidth(width = 157.dp)
                            .requiredHeight(height = 156.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                    )
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 219.dp,
                                y = 417.dp
                            )
                            .requiredWidth(width = 147.dp)
                            .requiredHeight(height = 150.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                    ) {
                        Text(
                            text = "Grapes",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 43.dp,
                                    y = 118.dp
                                )
                                .requiredWidth(width = 115.dp)
                                .requiredHeight(height = 68.dp)
                        )

                    }
                    Image(
                        painter = painterResource(id = R.drawable.grapes),
                        contentDescription = " ",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 201.dp,
                                y = 377.dp
                            )
                            .requiredWidth(width = 150.dp)
                            .requiredHeight(height = 150.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.prof),
                        contentDescription = " ",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 1.dp,
                                y = 26.dp
                            )
                            .requiredSize(size = 42.dp)
                            .clip(shape = CircleShape)
                            .border(
                                border = BorderStroke(0.10000000149011612.dp, Color(0xffbdbdbd)),
                                shape = CircleShape
                            )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.apples
                        ),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 216.dp,
                                y = 172.dp
                            )
                            .requiredWidth(width = 150.dp)
                            .requiredHeight(height = 157.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                    )

                        Image(
                            painter = painterResource(id = R.drawable.custardapple),
                            contentDescription = " ",
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 21.dp,
                                    y = 355.dp
                                )
                                .requiredWidth(width = 167.dp)
                                .requiredHeight(height = 186.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                        )

                }

            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}