package com.sameh.jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sameh.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                ListNames()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListNames() {
    var userName by remember {
        mutableStateOf("")
    }
    var userNamesList by remember {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
        ) {
            OutlinedTextField(
                value = userName,
                onValueChange = { text ->
                    userName = text
                },
                label = { Text(text = "Enter Your Name") },
                modifier = Modifier.weight(1F)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    if (userName.isNotEmpty() && userName.isNotBlank()) {
                        userNamesList = userNamesList + userName
                        userName = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = colorResource(id = R.color.black),
                ),
                border = BorderStroke(
                    8.dp,
                    color = Color.Yellow
                )
            ) {
                Text(
                    text = "Add User",
                    fontSize = 24.sp
                )
            }
        }
        SetUserNamesList(userNamesList)
    }
}

@Composable
fun SetUserNamesList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        items(names) { name ->
            Text(
                text = name,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Divider()
        }
    }
}

@Composable
fun BoxAndRowAndText(text: String, text2: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1F)
            )
            Text(
                text = text2,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1F)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(2F)
            )
            Text(
                text = text2,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1F)
            )
        }
    }
}

@Composable
fun LazyRowColumn(count: Int) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(count) { i ->
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        LazyColumn {
            items(count) { i ->
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun CounterUi() {
    var count by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            fontSize = 20.sp,
            color = Color.Black
        )
        ElevatedButton(
            onClick = {
                count++
            },
        ) {
            Text(
                text = "Counter Now $count click to increase",
                color = Color.Black,
                fontSize = 20.sp,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOutLinedTextField() {
    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = textValue.value,
        onValueChange = { text ->
            textValue.value = text
        },
        label = { Text(text = stringResource(id = R.string.app_name)) },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Color.Red,
            focusedBorderColor = Color.Black
        )
    )
}

@Composable
fun MyGroupRadioButton() {
    val radioButtons = listOf(0, 1, 2)

    val selectedButton = remember {
        mutableStateOf(radioButtons.first())
    }

    Column {
        radioButtons.forEach { i ->
            val isSelected = i == selectedButton.value
            val colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Yellow,
            )
            RadioButton(
                selected = isSelected,
                onClick = {
                    selectedButton.value = i
                },
                colors = colors
            )
        }
    }
}

@Composable
fun MyFLB() {
    FloatingActionButton(
        onClick = {
        },
        modifier = Modifier,
        contentColor = Color.Red
    ) {
        Icon(Icons.Filled.Done, contentDescription = null)
        //Text(text = "FAB")
    }
}

@Composable
fun MyLinearProgress() {
    LinearProgressIndicator(progress = 0.75F)
}

@Composable
fun MyCircularProgress() {
    CircularProgressIndicator(
        color = Color.Cyan,
        strokeWidth = 10.dp
    )
}

@Composable
fun MyAlertDialog() {
    val showDialog = remember {
        mutableStateOf(true)
    }

    if (showDialog.value) {
        AlertDialog(
            title = { Text(text = "My Alert Dialog") },
            text = { Text(text = "Description of Alert Dialog") },
            icon = { Icon(Icons.Default.Build, contentDescription = null) },
            onDismissRequest = {
                showDialog.value = false
            },
            confirmButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "No")
                }
            }
        )
    }
}

@Composable
fun MyRow() {
    // linear layout horizontal
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
        //horizontalArrangement = Arrangement.Start,
        //horizontalArrangement = Arrangement.End,
        //horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "text 1",
            style = TextStyle(
                background = Color.Blue,
                fontSize = 16.sp,
                color = Color.White
            )
        )
        Text(
            text = "text 2",
            style = TextStyle(
                background = Color.Blue,
                fontSize = 16.sp,
                color = Color.White
            )
        )
        Text(
            text = "text 3",
            style = TextStyle(
                background = Color.Blue,
                fontSize = 16.sp,
                color = Color.White
            )
        )
    }
}

@Composable
fun UseRowWithWeight() {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .width(250.dp)
            .height(250.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MyRowWithWeight()
    }
}

@Composable
fun RowScope.MyRowWithWeight() {
    Text(
        text = "text 1",
        style = TextStyle(
            background = Color.Red,
            fontSize = 16.sp,
            color = Color.White
        ),
        modifier = Modifier.weight(2F)
    )
    Text(
        text = "text 2",
        style = TextStyle(
            background = Color.Red,
            fontSize = 16.sp,
            color = Color.White
        ),
        modifier = Modifier.weight(1F)
    )
    Text(
        text = "text 3",
        style = TextStyle(
            background = Color.Red,
            fontSize = 16.sp,
            color = Color.White
        ),
        modifier = Modifier.weight(1F)
    )
}

@Composable
fun MyColumn() {
    // linear layout vertical
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "text 1",
            style = TextStyle(
                background = Color.Green,
                fontSize = 24.sp
            )
        )
        Text(
            text = "text 2",
            style = TextStyle(
                background = Color.Yellow,
                fontSize = 24.sp
            )
        )
        Text(
            text = "text 3",
            style = TextStyle(
                background = Color.Yellow,
                fontSize = 24.sp
            )
        )
    }
}

@Composable
fun UseColumnWithWeight() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .width(250.dp)
            .height(250.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyColumnWithWeight()
    }
}

@Composable
fun ColumnScope.MyColumnWithWeight() {
    Text(
        text = "text 1",
        style = TextStyle(
            background = Color.Yellow,
            fontSize = 24.sp,
            color = Color.Black
        ),
        modifier = Modifier.weight(2F)
    )
    Text(
        text = "text 2",
        style = TextStyle(
            background = Color.Yellow,
            fontSize = 24.sp,
            color = Color.Black
        ),
        modifier = Modifier.weight(1F)
    )
    Text(
        text = "text 3",
        style = TextStyle(
            background = Color.Yellow,
            fontSize = 24.sp,
            color = Color.Black
        ),
        modifier = Modifier.weight(1F)
    )
}

/*
        for call MyBox by parameter
        MyBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(Color.Green),
                    contentModifier = Modifier
                        .padding(16.dp)
                )
 */
@Composable
fun MyBox(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier
) {
    // like frame layout
    Box(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Text(
            text = "text 1",
            style = TextStyle(
                background = Color.Red,
                fontSize = 24.sp,
                color = Color.Black
            ),
            modifier = contentModifier.align(Alignment.TopStart)
        )
        Text(
            text = "text 2",
            style = TextStyle(
                background = Color.White,
                fontSize = 24.sp,
                color = Color.Black
            ),
            modifier = contentModifier.align(Alignment.Center)
        )
        Text(
            text = "text 3",
            style = TextStyle(
                background = Color.Black,
                fontSize = 24.sp,
                color = Color.White
            ),
            modifier = contentModifier.align(Alignment.BottomEnd)
        )
    }
}

/*
        for call MySurfaces by parameter
        Box(
            modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Cyan)
                ){
                    MySurfaces(
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
              }
 */
@Composable
fun MySurfaces(
    modifier: Modifier = Modifier
) {
    // layout use for root container because only can contain 1 view
    Surface(
        modifier = modifier
            .size(200.dp),
        color = Color.Red,
        contentColor = Color.Black
    ) {
        MyColumn()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@Composable
fun MyScaffold() {
    var presses by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                    }
                },
                title = {
                    Text("Top app bar")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.Red
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        contentColor = Color.Black
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button $presses times.
                """.trimIndent(),
            )
        }
    }
}

@Composable
fun VerticalScrolling(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Given the significant differences between the M2 and M3 color systems, there’s no reasonable mapping for Color parameters. Instead, use the Material Theme Builder tool to generate an M3 color scheme. Use the M2 colors as “core” source colors in the tool, which the tool expands into tonal palettes used by the M3 color scheme. The following mappings are recommended as a starting point:",
            fontSize = 24.sp,
            color = Color.Black
        )
        Text(
            text = "Given the significant differences between the M2 and M3 color systems, there’s no reasonable mapping for Color parameters. Instead, use the Material Theme Builder tool to generate an M3 color scheme. Use the M2 colors as “core” source colors in the tool, which the tool expands into tonal palettes used by the M3 color scheme. The following mappings are recommended as a starting point:",
            fontSize = 24.sp,
            color = Color.Gray
        )
        Text(
            text = "Given the significant differences between the M2 and M3 color systems, there’s no reasonable mapping for Color parameters. Instead, use the Material Theme Builder tool to generate an M3 color scheme. Use the M2 colors as “core” source colors in the tool, which the tool expands into tonal palettes used by the M3 color scheme. The following mappings are recommended as a starting point:",
            fontSize = 24.sp,
            color = Color.Cyan
        )
        Text(
            text = "Given the significant differences between the M2 and M3 color systems, there’s no reasonable mapping for Color parameters. Instead, use the Material Theme Builder tool to generate an M3 color scheme. Use the M2 colors as “core” source colors in the tool, which the tool expands into tonal palettes used by the M3 color scheme. The following mappings are recommended as a starting point:",
            fontSize = 24.sp,
            color = Color.Magenta
        )
    }
}

@Composable
fun HorizontalScrolling() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        Text(
            text = "Given the significant differences between the M2 and M3 color systems, there’s no reasonable mapping for Color parameters. Instead, use the Material Theme Builder tool to generate an M3 color scheme. Use the M2 colors as “core” source colors in the tool, which the tool expands into tonal palettes used by the M3 color scheme. The following mappings are recommended as a starting point:",
            fontSize = 24.sp,
            color = Color.Black
        )
        Text(
            text = "Given the significant differences between the M2 and M3 color systems, there’s no reasonable mapping for Color parameters. Instead, use the Material Theme Builder tool to generate an M3 color scheme. Use the M2 colors as “core” source colors in the tool, which the tool expands into tonal palettes used by the M3 color scheme. The following mappings are recommended as a starting point:",
            fontSize = 24.sp,
            color = Color.Red
        )
    }
}

// lazy column or row
data class Icon(
    val name: String,
    val icon: ImageVector
)

@Composable
fun ItemIcon(icon: Icon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = icon.icon, contentDescription = null,
            modifier = Modifier
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = icon.name,
            fontSize = 24.sp,
            modifier = Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
        )
    }
}

val iconsList: List<Icon> = listOf(
    Icon("List", Icons.Default.List),
    Icon("Add", Icons.Default.Add),
    Icon("Build", Icons.Default.Build),
    Icon("AccountBox", Icons.Default.AccountBox),
    Icon("AddCircle", Icons.Default.AddCircle),
    Icon("Clear", Icons.Default.Clear),
    Icon("Create", Icons.Default.Create),
    Icon("DateRange", Icons.Default.DateRange),
    Icon("List", Icons.Default.List),
    Icon("Add", Icons.Default.Add),
    Icon("Build", Icons.Default.Build),
    Icon("AccountBox", Icons.Default.AccountBox),
    Icon("AddCircle", Icons.Default.AddCircle),
    Icon("Clear", Icons.Default.Clear),
    Icon("Create", Icons.Default.Create),
    Icon("DateRange", Icons.Default.DateRange),
    Icon("List", Icons.Default.List),
    Icon("Add", Icons.Default.Add),
    Icon("Build", Icons.Default.Build),
    Icon("AccountBox", Icons.Default.AccountBox),
    Icon("AddCircle", Icons.Default.AddCircle),
    Icon("Clear", Icons.Default.Clear),
    Icon("Create", Icons.Default.Create),
    Icon("DateRange", Icons.Default.DateRange)
)

@Composable
fun MyLazyColumn(icons: List<Icon>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(icons) { icon ->
            ItemIcon(icon)
        }
    }
}

@Composable
fun MyLazyVerticalGrid(icons: List<Icon>) {
    LazyVerticalGrid(
//        columns = GridCells.Adaptive(180.dp),
        columns = GridCells.Fixed(4),
        content = {
            items(icons) { item ->
                GridItem(item)
            }
        })
}

@Composable
fun GridItem(icon: Icon) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            icon.icon, contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .padding(8.dp)
        )
        Text(
            text = icon.name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
    }
}

data class IconResource(val imageVector: ImageVector, val isVisible: Boolean = true)

val icons: List<IconResource> = listOf(
    IconResource(Icons.Filled.Build),
    IconResource(Icons.Filled.List),
    IconResource(Icons.Filled.AddCircle),
    IconResource(Icons.Filled.Menu),
    IconResource(Icons.Filled.Email),
    IconResource(Icons.Filled.Info),
    IconResource(Icons.Filled.Build),
    IconResource(Icons.Filled.List),
    IconResource(Icons.Filled.AddCircle),
    IconResource(Icons.Filled.Menu),
    IconResource(Icons.Filled.Email),
    IconResource(Icons.Filled.Info),
    IconResource(Icons.Filled.Build),
    IconResource(Icons.Filled.List),
    IconResource(Icons.Filled.AddCircle),
    IconResource(Icons.Filled.Menu),
    IconResource(Icons.Filled.Email),
    IconResource(Icons.Filled.Info),
    IconResource(Icons.Filled.Build),
    IconResource(Icons.Filled.List),
    IconResource(Icons.Filled.AddCircle),
    IconResource(Icons.Filled.Menu),
    IconResource(Icons.Filled.Email)
)

@Composable
fun CustomGridView(columnCount: Int) {
    val itemSize = icons.size
    val rowCount = ceil(itemSize.toFloat() / columnCount).toInt()
    val gridItems = mutableListOf<List<IconResource>>()
    var position = 0

    for (i in 0 until rowCount) {
        val rowItem = mutableListOf<IconResource>()
        for (j in 0 until columnCount) {
            if (position.inc() <= itemSize) {
                rowItem.add(icons[position++])
            }
        }

        val itemTiFill = columnCount - rowItem.size
        for (z in 0 until itemTiFill) {
            rowItem.add(IconResource(Icons.Filled.FavoriteBorder, false))
        }
        gridItems.add(rowItem)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(gridItems) { item ->
            RowItem(item)
        }
    }
}

@Composable
fun RowItem(rowItem: List<IconResource>) {
    Row {
        for (element in rowItem) {
            GridItem(element)
        }
    }
}

@Composable
fun RowScope.GridItem(icon: IconResource) {
    val colorTint = if (icon.isVisible) Color.Red else Color.Transparent
    Icon(
        icon.imageVector, contentDescription = null,
        tint = colorTint,
        modifier = Modifier
            .size(60.dp)
            .padding(16.dp)
            .weight(1F)
    )
}